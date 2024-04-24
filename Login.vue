<template>
  <div>
    <el-card class="login-form-layout" >
      <el-form
        autocomplete="on"
        :model="loginForm"
        ref="loginForm"
        label-position="left"
      >
        
        <h2 class="login-title color-main">登录页面</h2>
        <!-- 添加用于选择用户登录或管理员登录的单选按钮 -->
        <el-form-item>
          <el-radio-group v-model="loginType">
            <el-radio :label="'user'">用户登录</el-radio>
            <el-radio :label="'admin'">管理员登录</el-radio>
          </el-radio-group>
        </el-form-item>

        <el-form-item prop="username" v-if="loginType === 'user'">
          <el-input
            name="username"
            type="text"
            v-model="loginForm.username"
            autocomplete="on"
            placeholder="请输入用户名"
          >
            <span slot="prefix">
              <i class="el-icon-user"></i>
            </span>
          </el-input>
        </el-form-item>

        <el-form-item prop="password" v-if="loginType === 'user'">
          <el-input
            name="password"
            :type="pwdType"
            @keyup.enter.native="handleLogin"
            v-model="loginForm.password"
            autocomplete="on"
            placeholder="请输入密码"
          >
            <span slot="prefix">
              <i class="el-icon-coordinate"></i>
            </span>
            <span slot="suffix" @click="showPwd">
              <i class="el-icon-view"></i>
            </span>
          </el-input>
        </el-form-item>

          <!-- 显示管理员登录字段 -->
          <el-form-item prop="adminName" v-if="loginType === 'admin'">
            <el-input
            name="username"
            type="text"
            v-model="loginForm.adminName"
            autocomplete="on"
            placeholder="请输入管理员账号"
          >
            <span slot="prefix">
              <i class="el-icon-user"></i>
            </span>
          </el-input>
          <!-- 管理员登录输入字段 -->
        </el-form-item>

        <el-form-item prop="adminPassword" v-if="loginType === 'admin'">
          <el-input
            name="password"
            :type="pwdType"
            @keyup.enter.native="handleLogin"
            v-model="loginForm.adminPassword"
            autocomplete="on"
            placeholder="请输入密码"
          >
            <span slot="prefix">
              <i class="el-icon-coordinate"></i>
            </span>
            <span slot="suffix" @click="showPwd">
              <i class="el-icon-view"></i>
            </span>
          </el-input>
          <!-- 管理员登录密码输入字段 -->
        </el-form-item>

        <el-form-item style="margin-bottom: 30px" @keyup.enter.native.prevent="goToUserHome">
          <el-button
            style="width: 100%;margin-top: 50px;"
            type="primary"
            :loading="loading"
            @click.native.prevent="login"
          >登录</el-button>
        </el-form-item>
      </el-form>
      <!-- <div style="text-align: center; margin-top: 20px;">
        <button @click="goToRegister">没有账号?立即注册</button>
      </div> -->
      
    </el-card>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: "LoginComponent",
  data() {
    return {
      
      loginForm: {
        username: "",
        password: "",
        adminName:"",
        adminPassword:""
      },
      loading: false,
      pwdType: "password",
      loginType:'user'
    };
  },
  methods: {
    showPwd() {
      if (this.pwdType === "password") {
        this.pwdType = "";
      } else {
        this.pwdType = "password";
      }
    },
     goToUserHome()
      {
        this.$store.commit('setUserName',this.loginForm.username)
        this.$router.push({ name: 'UserHome' });
      },
      goToAdminHome()
      {
        this.$store.commit('setUserName',this.loginForm.adminName)
        this.$router.push({ name: 'AdminHome' });
      }, 
      login(){
      if(this.loginType === 'user') { 
        //用户登录
      if (!this.loginForm.username || !this.loginForm.password) {
        alert('用户名和密码不能为空');
        return;
      }
      else{
       const userInfo ={
        username: this.loginForm.username,
        password: this.loginForm.password
      };
      const userInfoJSON = JSON.stringify(userInfo);
      axios.post('http://127.0.0.1:80/api/userInfo', userInfoJSON, {
        headers: {
          'Content-Type': 'application/json'
        }
      }).then(response => {
        this.responseData = response.data;
        if (this.responseData === 1) {
          this.$store.commit('setUserName',this.loginForm.username)
          this.$router.push({name:'UserHome'});
        } else {
          alert('账号或密码错误，请重试!');
        }
      }).catch(error => {
        console.error('出现错误：', error);
      }); 
      this.$bus.$emit('getName',this.loginForm.username);
    }
    }else if(this.loginType==='admin'){
      if (!this.loginForm.adminName || !this.loginForm.adminPassword) {
        alert('管理员账号和密码不能为空');
        return;
      }
      else{
       const adminInfo ={
        adminName: this.loginForm.adminName,
        adminPassword: this.loginForm.adminPassword
      };
      const adminInfoJSON = JSON.stringify(adminInfo);
      axios.post('http://127.0.0.1:80/api/adminInfo', adminInfoJSON, {
        headers: {
          'Content-Type': 'application/json'
        }
      }).then(response => {
        this.responseData = response.data;
        if (this.responseData === 1) {
          this.$store.commit('setAdminName',this.loginForm.adminName)
          this.$router.push({name:'AdminHome'});
        } else {
          alert('账号或密码错误，请重试!');
        }
      }).catch(error => {
        console.error('出现错误：', error);
      }); 
      this.$bus.$emit('getName',this.loginForm.adminName);
    }
    }
    },  
  
      
    goToRegister()
    {
      this.$router.push({ name: 'Register' })
    },
  }
  

}

</script>

<style scoped>
.login-form-layout {
  position: absolute;
  left: 0;
  right: 0;
  width: 360px;
  margin: 140px auto;
  border-top: 10px solid #409eff;
}

.login-title {
  text-align: center;
}

.login-center-layout {
  background: #409eff;
  width: auto;
  height: auto;
  max-width: 100%;
  max-height: 100%;
  margin-top: 200px;
}
</style>
