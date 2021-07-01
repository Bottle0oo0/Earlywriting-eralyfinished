<template>
  <div>
    <div>
      <el-input class="control-xl" v-model="key" placeholder="科室编号"></el-input>
      <el-button type="primary" icon="el-icon-search" plain circle @click="searchDepartment(key)"></el-button>
      <el-button type="primary" plain @click="dialogFormVisible=true">新增科室</el-button>
      <el-button type="primary" plain @click="displayAll()">显示全部</el-button><br>
      <el-dialog title="新增科室" @close='clear()' width="30%" :visible.sync="dialogFormVisible" >
        <el-form :model="department">
          <el-form-item label="科室编号" :label-width="formLabelWidth">
            <el-input v-model="department.code" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="科室名称" :label-width="formLabelWidth">
            <el-input v-model="department.name" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="科室分类" :label-width="formLabelWidth">
            <el-input v-model="department.category" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="科室类型" :label-width="formLabelWidth">
            <el-input v-model="department.type" autocomplete="off"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogFormVisible = false">取 消</el-button>
          <el-button type="primary" @click="dialogFormVisible = false;addDepartment()">确 定</el-button>
        </div>
      </el-dialog>
    </div>

    <div>
      <el-table :data="departments" id="department_table" height="600px" style="margin-left: 30px; margin-right: 30px; width: 90%;" @selection-change="handleSelection">
        <el-table-column type="selection" :selectable="checkSelectable"></el-table-column>
        <el-table-column type="index"></el-table-column>
        <el-table-column label="科室编号" prop="code"></el-table-column>
        <el-table-column label="科室名称" prop="name"></el-table-column>
        <el-table-column label="科室分类" prop="category"></el-table-column>
        <el-table-column label="科室类型" prop="type"></el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button type="primary" plain @click="handleEdit(scope.$index, scope.row);editDialogFormVisible=true">编辑</el-button>
            <el-button type="danger" plain @click="handleDelete(scope.$index, scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>

      <el-dialog title="修改科室" @close='clear()' width="30%" :visible.sync="editDialogFormVisible" >
        <el-form :model="department">
          <el-form-item label="科室编号" :label-width="formLabelWidth" >
            <el-input v-model="department.code" autocomplete="off" :disabled="true"></el-input>
          </el-form-item>
          <el-form-item label="科室名称" :label-width="formLabelWidth">
            <el-input v-model="department.name" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="科室分类" :label-width="formLabelWidth">
            <el-input v-model="department.category" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="科室类型" :label-width="formLabelWidth">
            <el-input v-model="department.type" autocomplete="off"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="editDialogFormVisible = false">取 消</el-button>
          <el-button type="primary" @click="editDialogFormVisible = false;updateDepartment()">确 定</el-button>
        </div>
      </el-dialog>

    </div>

  </div>
</template>

<script>
import axios from "axios"
export default {
  name: 'DepartManage',
  data() {
    return {
      departments:[],
      department: {
        id: null,
        code: null,
        name: null,
        category: null,
        type: null
      },
      dialogFormVisible: false,
      editDialogFormVisible : false,
      formLabelWidth: '120px',
      searchContent : null,
      key : null
    }
  },
  methods: {
    init(){
      if(this.searchContent == null) {
        axios.post("/register/init_depart").then((res) => {
          this.departments = res.data
          console.log(res.data)
        })

      }else{
        axios.post("/manage/search_department", {key:this.searchContent}).then((res) => {
          this.departments = res.data
        })
      }this.clear()

    },
    clear(){
      this.department.code=null
      this.department.name=null
      this.department.category=null
      this.department.type=null
      this.key = null
    },
    displayAll(){
      this.searchContent=null;
      this.init()
    },
    searchDepartment(name) {
      this.searchContent = name
      this.init()
    },
    checkSelectable(row) {
      // if (row.state == "未出药") return false;
      // else return true;
      return true
    },
    handleSelection(val) {
      this.selected = val
    },
    addDepartment(){
      axios.post("/manage/add_department", this.department).then((res)=>{
        if (res.data) {
          this.$message("添加成功")
          this.init()
        } else this.$message("添加失败")
      })
    },
    handleEdit(index, row){
      this.department.id = row.id
      this.department.code = row.code
      this.department.name = row.name
      this.department.type = row.type
      this.department.category = row.category
    },
    handleDelete(index, row){
      axios.post("/manage/delete_department", {id: this.departments[index].id}).then(this.init)
    },
    updateDepartment(){
      axios.post("/manage/update_department", this.department).then((res)=>{
        if (res.data) {
          this.$message("修改成功")
          this.init()
        } else this.$message("修改失败")
      })
    }
  },
  mounted() {
    this.init()
  }
}
</script>

<style scoped>
.main {
  margin-top: 30px;
  margin-left: 30px;
}
.foot {
  margin-top: 50px;
  margin-left: 30px;
}
span {
  color: gray;
  font-size: 14px;
}
</style>
