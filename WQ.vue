<template>
    <div class="container">
      
      <div class="main">
        <el-divider />
        <!-- 这里是主要内容 -->
        <div class="info">
          <el-descriptions  border="true" column="2">
            <el-descriptions-item label="用户信息">{{ userName }}</el-descriptions-item>
            <el-descriptions-item label="运动场名称">网球</el-descriptions-item>
            <el-descriptions-item label="运动场状态">
              <el-button type="success">可预约</el-button>
            </el-descriptions-item>
            <el-descriptions-item label="运动场状态">
              <el-button type="warning">已预约</el-button>
            </el-descriptions-item>
            <el-descriptions-item label="运动场状态">
              <el-button type="danger">已占用</el-button>
            </el-descriptions-item>
            <el-descriptions-item label="运动场状态">
              <el-button type="info">不可用</el-button>
            </el-descriptions-item>
          </el-descriptions>
        </div>
        <el-divider />
        <div class="book">
          <table>
            <thead>
              <tr>
                <th></th> <!-- 空白单元格 -->
                <th colspan="6">网球场</th> <!-- 跨越6列 -->
              </tr>
            </thead>
            <tbody>
              <!-- 时间段 -->
              <tr>
                <th>时间段</th>
                <th v-for="(field, fieldIndex) in fields" :key="fieldIndex">{{  field.id +' 号场 '}}</th>
              </tr>
              <tr v-for="(timeSlot, index) in timeSlots" :key="index">
                <td>{{ timeSlot.time }}</td>
                <td v-for="(field, fieldIndex) in timeSlot.fields" :key="fieldIndex">
                  <button :id="'field' + field.id + '_button' + (index + 1)" class="field-button" 
                    :style="{ backgroundColor: field.color }" @click="toggleReservation(field.id, index + 1)">
                  </button>
                </td>
              </tr>
              
            </tbody>
          </table>
        </div>
      </div>
      <div class="footer">
        <h1>footer</h1>
      </div>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    name: 'WQComponent',
    data() {
      return {
        
        responseData: null,
        fields: [
          { id: 1 },
          { id: 2 },
          { id: 3 },
          { id: 4 },
          { id: 5 },
          { id: 6 }
        ],
        timeSlots: []
      };
    },
    computed: {
          userName() {
            return this.$store.state.userName;
          }
        },
    mounted() {
      // 生成时间段
      this.generateTimeSlots();
      this.getData();
    },
    methods: {
      toggleReservation(fieldId, timeIndex) {
        const timeSlot = this.timeSlots[timeIndex - 1];
        const field = timeSlot.fields[fieldId - 1];
  
        if (field.color === '#67C23A') {
          // 绿色按钮表示可预约，弹出预约确认对话框
          this.reserveSlot(fieldId, timeIndex);
        } else if (field.color === '#E6A23C') {
          // 用户已经预约的按钮颜色为黄色，取消预约
          this.cancelReservation(fieldId, timeIndex);
        } else if(field.color === '##F56C6C'){
          // 其他用户已经预约的按钮颜色为红色，不可操作
          this.$message.warning('该时段已被其他用户预约！');
        }else {
          //场地不可用，按钮为灰色，不可操作
          this.$message.warning('该场地目前不可用');
        }
      },
  
      // 处理预约的方法
      // 处理预约的方法
      reserveSlot(fieldId, timeIndex) {
        const currentTimeSlot = this.timeSlots[timeIndex - 1];
        const currentField = currentTimeSlot.fields[fieldId - 1];
  
        // 统计用户已预约的时间段数量
        let reservedCount = 0;
        this.timeSlots.forEach(slot => {
          if (slot.fields[fieldId - 1].color === '#E6A23C') {
            reservedCount++;
          }
        });
  
        // 如果用户已经预约了两个时间段，不再允许预约其他时间段
        if (reservedCount >= 2) {
          this.$message.warning('您已经预约了两个时间段，不能再进行其他预约！');
          return;
        }
  
        // 显示确认对话框
        this.$confirm('是否预约当前时段？', '预约确认', {
          confirmButtonText: '是',
          cancelButtonText: '否',
          type: 'warning'
        }).then(() => {
          // 用户确认预约当前时段
          const reservationData = {
            type:'网球',
            id: fieldId,
            time: timeIndex,
            isBook: true,
            userName: this.$store.state.userName
          };
  
          // 发送预约数据到后端
          axios.post('http://127.0.0.1:80/api/userInfo/book', reservationData)
            .then(response => {
              if (response.data === 1) {
                // 预约成功，将按钮颜色更新为黄色
                currentField.color = '#E6A23C';
                this.$store.commit('updateUserBooking', reservationData);
                this.$message.success('预约成功！');
                reservedCount++;
  
                // 如果已经预约两次，不再询问预约下一个时段
                if (reservedCount >= 2) {
                  return;
                }
                // 如果下一个时间段存在且未被预约，则询问用户是否预约下一个时间段
                const nextTimeSlot = this.timeSlots[timeIndex];
                if (nextTimeSlot && nextTimeSlot.fields[fieldId - 1].color === '#67C23A') {
                  this.$confirm('是否预约下一个时段？', '预约确认', {
                    confirmButtonText: '是',
                    cancelButtonText: '否',
                    type: 'warning'
                  }).then(() => {
                    // 用户确认预约下一个时段
                    this.reserveSlot(fieldId, timeIndex + 1);
                  }).catch(() => {
                    // 用户取消预约下一个时段
                    this.$message.info('已取消预约下一个时段！');
                  });
                }
              } else {
                this.$message.error('预约失败，请稍后重试！');
              }
            })
            .catch(error => {
              console.error('预约失败:', error);
              this.$message.error('预约失败，请稍后重试！');
            });
        }).catch(() => {
          // 用户取消预约当前时段
          this.$message.info('已取消预约！');
        });
      },
  
      // 处理取消预约的方法
      cancelReservation(fieldId, timeIndex) {
        // 显示确认对话框
        this.$confirm('是否取消预约当前时段？', '取消预约确认', {
          confirmButtonText: '是',
          cancelButtonText: '否',
          type: 'warning'
        }).then(() => {
          // 用户确认取消预约，向后端发送取消预约数据
          const cancelData = {
            type:'网球',
            id: fieldId,
            time: timeIndex,
            isBook: false,
            userName: this.$store.state.userName
          };
  
          // 发送取消预约数据到后端
          axios.post('http://127.0.0.1:80/api/userInfo/book', cancelData)
            .then(response => {
              if (response.data === 1) {
                // 取消预约成功，将按钮颜色更新为绿色
                this.timeSlots[timeIndex - 1].fields[fieldId - 1].color = '#67C23A';
                this.$message.success('取消预约成功！');
              } else {
                this.$message.error('取消预约失败，请稍后重试！');
              }
            })
            .catch(error => {
              console.error('取消预约失败:', error);
              this.$message.error('取消预约失败，请稍后重试！');
            });
        }).catch(() => {
          // 用户取消取消预约
          this.$message.info('已取消取消预约！');
        });
      },
  
  
      getData(){
        axios.post('http://127.0.0.1:80/api/userInfo/wq').then(response => {
          this.responseData = response.data;
          
          // 根据后端数据更新按钮状态
          this.updateButtonStatus(this.responseData);
          
        }).catch(error => {
          console.error('获取数据时出错:', error);
        });
      },
      generateTimeSlots() {
        // 生成时间段的逻辑，这里简单示例
        const times = ['8:00-9:00', '9:00-10:00', '10:00-11:00', '11:00-12:00', '12:00-13:00', '13:00-14:00', '14:00-15:00', '15:00-16:00', '16:00-17:00', '17:00-18:00', '18:00-19:00', '19:00-20:00']; // 你可以根据需要生成更多时间段
        this.timeSlots = times.map(time => {
          return {
            time: time,
            fields: this.fields.map(field => ({ id: field.id, color: '#67C23A' })) // 生成初始状态为绿色的按钮
          };
        });
      },
      updateButtonStatus(backendData) {
      // 根据后端数据更新按钮状态
          backendData.forEach(data => {
            const fieldIndex = this.fields.findIndex(field => field.id === data.id);
            if (fieldIndex !== -1) {
              const columnIndex = fieldIndex + 1; // 计算列索引，从1开始
              const status = data.status;
              if (status === 1) {
                // 整列按钮变成灰色
                this.timeSlots.forEach(slot => {
                  const button = slot.fields.find(field => field.id === data.id);
                  if (button) button.color = '#909399';
                });
              } else {
                // 根据时间段的状态值更新按钮颜色
                Object.keys(data).forEach(key => {
                  if (key.startsWith('time')) {
                    const timeIndex = parseInt(key.slice(4), 10) - 1; // 获取时间段索引
                    if (data[key] === 1) {
                      if (data.userName !== this.$store.state.userName) {
                        // 如果被其他用户预订，将按钮颜色更改为黄色
                        this.timeSlots[timeIndex].fields[columnIndex - 1].color = '#F56C6C';
                      } else {
                        // 如果被当前用户预订，将按钮颜色更改为红色
                        this.timeSlots[timeIndex].fields[columnIndex - 1].color = '#E6A23C';
                      }
                    }
                  }
                });
              }
            }
          });
        }
  
  
    }
  }
  </script>
  
  
  
  <style scoped>
  .container {
    height: 100%;
    margin: 0;
    padding: 0;
    display: flex;
    flex-direction: column;
  }
  
  
  
  .main {
    flex: 3;
    padding: 20px 100px;
    display: flex;
    flex-direction: column;
  }
  
  /* 可根据需要自行添加样式 */
  .info {
    flex: 2;
    margin-bottom: 20px;
  }
  
  .book {
    flex: 3;
    background-color: #eee;
  }
  
  .book table {
    width: 100%;
    border-collapse: collapse;
  }
  
  .book th,
  .book td {
    border: 1px solid #3d3737;
    padding: 0; 
    text-align: center;
  }
  
  .book th {
    background-color: #ffffff;
  }
  
  .book button {
    width: calc(100% - 3px); /* 留出一定边距 */
    height: calc(100% - 3px); /* 留出一定边距 */
    padding: 15px;
    box-sizing: border-box;
    border: none;
  }
  .book button.green:hover {
    background-color: lightgreen; /* 绿色按钮悬浮时的背景颜色 */
  }
  .el-row {
    margin-bottom: 20px;
  }
  .el-row:last-child {
    margin-bottom: 0;
  }
  .el-col {
    border-radius: 4px;
  }
  
  .grid-content {
    border-radius: 4px;
    min-height: 36px;
  }
  
  </style>
  