<template>
  <div @keyup.enter="search">
    <el-table
      :data="users"
      stripe
      style="width: 100%">
      <!-- 表格列 -->
      <el-table-column
      prop="type"
      label="场地类型"
      width="180">
    </el-table-column>
    <el-table-column
      prop="sportId"
      label="场地号"
      width="180">
    </el-table-column>
    <el-table-column
      prop="Userid"
      label="姓名"
      width="180">
    </el-table-column>
    <el-table-column
      prop="time"
      label="预约时段">
    </el-table-column>
    <el-table-column label="操作">
  <template slot-scope="scope">
    <el-button
      v-if="!scope.row.isPaid" 
      size="mini"
      @click="handleEdit(scope.$index, scope.row)">确认支付</el-button>
    <el-button
      v-else 
      size="mini"
      type="success">
      已支付
    </el-button>
  </template>
</el-table-column>
    </el-table>
    
    <div class="search-container">
      <i class="el-icon-search" :style="{ 'font-size': '24px' }"></i>
      <el-input
        placeholder="请输入内容"
        v-model="searchTerm"
        clearable
        :style="{ width: '200px', margin: '2px' }">
      </el-input>
    </div>
    
    <div v-if="errorMessage" style="color: red;">{{ errorMessage }}</div>
    
    <el-button class="send-button" type="primary" plain @click="showConfirmDialog">一键清除当日数据</el-button>
    
    <el-dialog
      title="确认"
      :visible.sync="dialogVisible"
      width="30%"
      center>
      <span>是否确认清除当日数据？</span>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="clearData">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: "AdminHomeComponent",
  data() {
    return {
      searchTerm: '',
      users: [],
      dialogVisible: false
    };
  },
  methods: {
    handleEdit(index, row) {
      row.isPaid = true;
    },
      
    search() {
      const timeMapping = {
        '8': '8:00-9:00',
        '9': '9:00-10:00',
        '10': '10:00-11:00',
        '11': '11:00-12:00',
        '12': '12:00-13:00',
        '13': '13:00-14:00',
        '14': '14:00-15:00',
        '15': '15:00-16:00',
        '16': '16:00-17:00',
        '17': '17:00-18:00',
        '18': '18:00-19:00',
        '19': '19:00-20:00'
      };

      const searchData = {
        UserId: this.searchTerm
      };

      axios.post('http://localhost:80/api/admin/sport', searchData)
        .then(response => {
          // 对返回的数据进行处理
          console.log(response.data)
          this.users = response.data.map(user => {
            // 如果用户的时间在时间映射中存在，则替换时间值为对应的时间范围
            if (timeMapping[user.time]) {
              user.time = timeMapping[user.time];
            }
            return user;
          });
          this.errorMessage = ''; // 清空错误消息
        })
        .catch(error => {
          console.error('未搜索到该用户:', error);
          this.errorMessage = '未搜索到用户，请稍后重试。'; // 设置错误消息
          this.users = []; // 清空用户列表
        });
    },
    
    showConfirmDialog() {
      this.dialogVisible = true;
    },
    
    clearData() {
      const deleteData = {
        delete: true
      };
      // 向后端发送清除数据的请求
      axios.post('http://localhost:80/api/admin/delete', JSON.stringify(deleteData))
        .then(response => {
          if (response.data === 1) {
            // 清除成功
            console.log('数据已清除');
            this.$message({
              type: 'success',
              message: '数据已清除'
            });
          } else {
            // 清除失败
            console.error('清除数据失败');
            this.$message.error('清除数据失败');
          }
          // 关闭对话框
          this.dialogVisible = false;
        })
        .catch(error => {
          console.error('清除数据失败:', error);
          // 清除失败
          this.$message.error('清除数据失败');
        });
    }

  }
};
</script>

<style>
.search-container {
  position: absolute;
  top: 10px;
  right: 10px;
  display: flex;
  align-items: center;
}

.send-button {
  position: absolute;
  bottom: 10px;
  right: 10px;
}
</style>
