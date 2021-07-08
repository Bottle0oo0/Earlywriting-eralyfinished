<template>
  <div>
    <div>
      <el-input class="control-xl" v-model="key" placeholder="请输入药品助记码"></el-input>
      <el-button type="primary" icon="el-icon-search" plain circle @click="searchDrug(key)"></el-button>
      <el-button type="primary" plain @click="dialogFormVisible=true">新增药品</el-button>
      <el-button type="primary" plain @click="displayAll()">显示全部</el-button><br>

      <el-dialog title="新增药品" @close='clear()' width="30%" :visible.sync="dialogFormVisible" >
        <el-form :model="drug">
          <el-form-item label="药物编号" :label-width="formLabelWidth">
            <el-input v-model="drug.code" autocomplete="off"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogFormVisible = false">取 消</el-button>
          <el-button type="primary" @click="dialogFormVisible = false;addDrug()">确 定</el-button>
        </div>
      </el-dialog>
    </div>

    <div>
      <el-table :data="drugs" id="drug_table" height="600px" style="margin-left: 30px; margin-right: 30px; width: 100%;" @selection-change="handleSelection">
        <el-table-column type="selection" :selectable="checkSelectable"></el-table-column>
        <el-table-column label="药品编号" prop="code"></el-table-column>
        <el-table-column label="药品名称" prop="name"></el-table-column>
        <el-table-column label="规格" prop="format"></el-table-column>
        <el-table-column label="单位" prop="unit"></el-table-column>
        <el-table-column label="单价" prop="price"></el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button type="primary" plain @click="editDialogFormVisible=true">编辑</el-button>
            <el-button type="danger" plain @click="handleDelete(scope.$index, scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>

      <el-dialog title="修改药物" @close='clear()' width="30%" :visible.sync="editDialogFormVisible" >
        <el-form :model="drug">
          <el-form-item label="药物编号" :label-width="formLabelWidth" >
            <el-input v-model="drug.code" autocomplete="off" :disabled="true"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="editDialogFormVisible = false">取 消</el-button>
          <el-button type="primary" @click="editDialogFormVisible = false;updateDrug()">确 定</el-button>
        </div>
      </el-dialog>

    </div>

  </div>
</template>

<script>
import axios from "axios"
export default {
  name: "MedicineManage",
  data() {
    return {
      drugs:[],
      drug: {
        id: null,
        code: null,
        name: null,
        format: null,
        unit: null,
        manufacturer: null,
        dosage: null,
        type: null,
        price: null,
        mnemonicCode: null
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
        axios.post("/manage/get_all_drug").then((res) => {
          this.drugs = res.data
        })

      }else{
        axios.post("/manage/search_drug", {key:this.searchContent}).then((res) => {
          this.drugs = res.data
        })
      }this.clear()

    },
    clear(){
    },
    displayAll(){
      this.searchContent=null;
      this.init()
    },
    searchDrug(name) {
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
    addDrug(){
      axios.post("/manage/add_drug", this.drug).then((res)=>{
        if (res.data) {
          this.$message("添加成功")
          this.init()
        } else this.$message("添加失败")
      })
    },
    handleEdit(index, row){
    },

    handleDelete(index, row){
      axios.post("/manage/delete_drug", {id: this.drugs[index].id}).then(this.init)
    },
    updateDrug(){
      axios.post("/manage/update_drug", this.drug).then((res)=>{
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
