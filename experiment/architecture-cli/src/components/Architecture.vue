<template>
  <div id="app">
    <el-card class="box-card">
      <div slot="header">经典软件体系结构教学软件</div>
      <el-select v-model="selectedArchitecture" placeholder="请选择体系结构风格">
        <el-option
          v-for="item in architectures"
          :key="item.value"
          :label="item.label"
          :value="item.value">
        </el-option>
      </el-select>
      <el-button type="primary" @click="processFile">处理文件</el-button>
      <el-textarea v-model="result" rows="10"></el-textarea>
      <div v-if="selectedInfo" class="info-panel">
        <h2>{{ selectedInfo.title }}</h2>
        <el-card class="description-box">
          <p>{{ selectedInfo.description }}</p>
        </el-card>
        <el-link :href="selectedInfo.code" target="_blank" class="code-link">
          查看代码
        </el-link>
      </div>
    </el-card>
  </div>
</template>

<script>
import axios from 'axios';
import { Select, Option, Button, Input, Card, Col, Row, Link, Message } from 'element-ui';

export default {
  components: {
    [Select.name]: Select,
    [Option.name]: Option,
    [Button.name]: Button,
    [Input.name]: Input,
    [Card.name]: Card,
    [Row.name]: Row,
    [Col.name]: Col,
    [Link.name]: Link,
  },
  data() {
    return {
      selectedArchitecture: '',
      result: '',
      selectedInfo: null,
      architectures: [
        { value: '主程序-子程序', label: '主程序-子程序' },
        { value: '面向对象', label: '面向对象' },
        { value: '事件系统', label: '事件系统' },
        { value: '管道-过滤器', label: '管道-过滤器' },
      ]
    };
  },
  methods: {
    async processFile() {
      if (!this.selectedArchitecture) {
        this.$message({
          message: '请选择一个体系结构风格',
          type: 'warning'
        });
        return;
      }
      try {
        const response = await axios.get('api/process', {
          params: { architecture: this.selectedArchitecture }
        });
        this.result = response.data;
        this.selectedInfo = {
          title: response.data.data.title,
          description: response.data.data.description,
          code: response.data.data.url
        };
      } catch (error) {
        this.$message.error('请求失败: ' + error.message);
      }
    },
  }
};
</script>

<style>
#app {
  text-align: center;
}
.box-card {
  width: 60%;
  margin: 20px auto;
}
.info-panel {
  margin-top: 20px;
}
.description-box {
  margin-top: 10px;
  padding: 15px;
  border: 1px solid #ebeef5;
  text-align: left;
}
.code-link {
  display: block;
  margin-top: 10px;
}
</style>