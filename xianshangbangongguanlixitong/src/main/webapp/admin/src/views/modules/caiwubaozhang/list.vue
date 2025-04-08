<template>
    <div class="main-content">
        <el-dialog title="管理审核" :visible.sync="caiwubaozhangYesnoTypesVisible1">
            <el-form :model="form1">
                <input type="hidden" v-model="form1.id">
                <el-form-item label="审核" >
                    <el-select v-model="form1.caiwubaozhangGuanliYesnoTypes" placeholder="请选择管理审核状态">
                        <el-option label="同意" value="2"></el-option>
                        <el-option label="拒绝" value="3"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="经理审核意见">
                    <el-input type="textarea" v-model="form1.caiwubaozhangGuanliYesnoText" placeholder="管理审核意见"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="caiwubaozhangYesnoTypesVisible1 = false">取 消</el-button>
                <el-button type="primary" @click="caiwubaozhangYesnoTypesShenhe1">审 核</el-button>
            </div>
        </el-dialog>

        <el-dialog title="经理审核" :visible.sync="caiwubaozhangYesnoTypesVisible">
            <el-form :model="form">
                <input type="hidden" v-model="form.id">
                <el-form-item label="审核" >
                    <el-select v-model="form.caiwubaozhangYesnoTypes" placeholder="请选择经理审核状态">
                        <el-option label="同意" value="2"></el-option>
                        <el-option label="拒绝" value="3"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="经理审核意见">
                    <el-input type="textarea" v-model="form.caiwubaozhangYesnoText" placeholder="经理审核意见"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="caiwubaozhangYesnoTypesVisible = false">取 消</el-button>
                <el-button type="primary" @click="caiwubaozhangYesnoTypesShenhe">审 核</el-button>
            </div>
        </el-dialog>

        <!-- 条件查询 -->
        <div v-if="showFlag">
            <el-form :inline="true" :model="searchForm" class="form-content">
                <el-row :gutter="20" class="slt" :style="{justifyContent:contents.searchBoxPosition=='1'?'flex-start':contents.searchBoxPosition=='2'?'center':'flex-end'}">
                         
                     <el-form-item :label="contents.inputTitle == 1 ? '财务报账标题' : ''">
                         <el-input prefix-icon="el-icon-search" v-model="searchForm.caiwubaozhangName" placeholder="财务报账标题" clearable></el-input>
                     </el-form-item>
         
                     <el-form-item :label="contents.inputTitle == 1 ? '财务报账类型' : ''">
                        <el-select v-model="searchForm.caiwubaozhangTypes" placeholder="请选择财务报账类型">
                            <el-option label="=-请选择-=" value=""></el-option>
                            <el-option
                               v-for="(item,index) in caiwubaozhangTypesSelectSearch"
                               v-bind:key="index"
                               :label="item.indexName"
                               :value="item.codeIndex">
                            <!--lable是要展示的名称-->
                            <!--value是值-->
                            </el-option>
                        </el-select>
                     </el-form-item>

                                         
                     <el-form-item :label="contents.inputTitle == 1 ? '管理员审核状态' : ''">
                        <el-select v-model="searchForm.caiwubaozhangGuanliYesnoTypes" placeholder="请选择管理员审核状态">
                            <el-option label="=-请选择-=" value=""></el-option>
                            <el-option
                               v-for="(item,index) in caiwubaozhangGuanliYesnoTypesSelectSearch"
                               v-bind:key="index"
                               :label="item.indexName"
                               :value="item.codeIndex">
                            <!--lable是要展示的名称-->
                            <!--value是值-->
                            </el-option>
                        </el-select>
                     </el-form-item>

                         
                     <el-form-item :label="contents.inputTitle == 1 ? '经理审核状态' : ''">
                        <el-select v-model="searchForm.caiwubaozhangYesnoTypes" placeholder="请选择经理审核状态">
                            <el-option label="=-请选择-=" value=""></el-option>
                            <el-option
                               v-for="(item,index) in caiwubaozhangYesnoTypesSelectSearch"
                               v-bind:key="index"
                               :label="item.indexName"
                               :value="item.codeIndex">
                            <!--lable是要展示的名称-->
                            <!--value是值-->
                            </el-option>
                        </el-select>
                     </el-form-item>

                        
                                         
                    <el-form-item :label="contents.inputTitle == 1 ? '员工编号' : ''">
                        <el-input prefix-icon="el-icon-search" v-model="searchForm.yonghuUuidNumber" placeholder="员工编号" clearable></el-input>
                    </el-form-item>
                     
                    <el-form-item :label="contents.inputTitle == 1 ? '员工姓名' : ''">
                        <el-input prefix-icon="el-icon-search" v-model="searchForm.yonghuName" placeholder="员工姓名" clearable></el-input>
                    </el-form-item>
                                                                                                     
                     
                    

                    <el-form-item>
                        <el-button type="success" @click="search()">查询<i class="el-icon-search el-icon--right"/></el-button>
                    </el-form-item>
                </el-row>
                <el-row class="ad" :style="{justifyContent:contents.btnAdAllBoxPosition=='1'?'flex-start':contents.btnAdAllBoxPosition=='2'?'center':'flex-end'}">
                    <el-form-item>
                        <el-button
                                v-if="isAuth('caiwubaozhang','新增')"
                                type="success"
                                icon="el-icon-plus"
                                @click="addOrUpdateHandler()"
                        >新增</el-button>
                        &nbsp;
                        <el-button
                                v-if="isAuth('caiwubaozhang','删除')"
                                :disabled="dataListSelections.length <= 0"
                                type="danger"
                                icon="el-icon-delete"
                                @click="deleteHandler()"
                        >删除</el-button>
                        &nbsp;
                        <el-button
                                v-if="isAuth('caiwubaozhang','报表')"
                                type="success"
                                icon="el-icon-pie-chart"
                                @click="chartDialog()"
                        >报表</el-button>
                        &nbsp;
                        <a style="text-decoration:none" class="el-button el-button--success"
                           v-if="isAuth('caiwubaozhang','导入导出')"
                           icon="el-icon-download"
                           href="http://localhost:8080/xianshangbangongguanlixitong/upload/caiwubaozhangMuBan.xls"
                        >批量导入财务报账数据模板</a>
                        &nbsp;
                        <el-upload
                                v-if="isAuth('caiwubaozhang','导入导出')"
                                style="display: inline-block"
                                :action="getActionUrl"
                                :on-success="caiwubaozhangUploadSuccess"
                                :on-error="caiwubaozhangUploadError"
                                :show-file-list = false>
                            <el-button
                                    v-if="isAuth('caiwubaozhang','导入导出')"
                                    type="success"
                                    icon="el-icon-upload2"
                            >批量导入财务报账数据</el-button>
                        </el-upload>
                        &nbsp;
                        <!-- 导出excel -->
                        <download-excel v-if="isAuth('caiwubaozhang','导入导出')" style="display: inline-block" class = "export-excel-wrapper" :data = "dataList" :fields = "json_fields" name = "caiwubaozhang.xls">
                            <!-- 导出excel -->
                            <el-button
                                    type="success"
                                    icon="el-icon-download"
                            >导出</el-button>
                        </download-excel>
                        &nbsp;
                    </el-form-item>
                </el-row>
            </el-form>
            <div class="table-content">
                <el-table class="tables" :size="contents.tableSize" :show-header="contents.tableShowHeader"
                          :header-row-style="headerRowStyle" :header-cell-style="headerCellStyle"
                          :border="contents.tableBorder"
                          :fit="contents.tableFit"
                          :stripe="contents.tableStripe"
                          :row-style="rowStyle"
                          :cell-style="cellStyle"
                          :style="{width: '100%',fontSize:contents.tableContentFontSize,color:contents.tableContentFontColor}"
                          v-if="isAuth('caiwubaozhang','查看')"
                          :data="dataList"
                          v-loading="dataListLoading"
                          @selection-change="selectionChangeHandler">
                    <el-table-column  v-if="contents.tableSelection"
                                      type="selection"
                                      header-align="center"
                                      align="center"
                                      width="50">
                    </el-table-column>
                    <el-table-column label="索引" v-if="contents.tableIndex" type="index" width="50" />
                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                      prop="yonghuUuidNumber"
                                      header-align="center"
                                      label="员工编号">
                        <template slot-scope="scope">
                            {{scope.row.yonghuUuidNumber}}
                        </template>
                    </el-table-column>
                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                      prop="yonghuName"
                                      header-align="center"
                                      label="员工姓名">
                        <template slot-scope="scope">
                            {{scope.row.yonghuName}}
                        </template>
                    </el-table-column>
                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                      prop="yonghuPhone"
                                      header-align="center"
                                      label="员工手机号">
                        <template slot-scope="scope">
                            {{scope.row.yonghuPhone}}
                        </template>
                    </el-table-column>
                    <el-table-column :sortable="contents.tableSortable" :align="contents.tableAlign" prop="yonghuPhoto"
                               header-align="center"
                               width="200"
                               label="员工头像">
                        <template slot-scope="scope">
                            <div v-if="scope.row.yonghuPhoto">
                                <img :src="scope.row.yonghuPhoto" width="100" height="100">
                            </div>
                            <div v-else>无图片</div>
                        </template>
                    </el-table-column>

                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                   prop="caiwubaozhangName"
                                   header-align="center"
                                   label="财务报账标题">
                        <template slot-scope="scope">
                            {{scope.row.caiwubaozhangName}}
                        </template>
                    </el-table-column>
                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                      prop="caiwubaozhangTypes"
                                      header-align="center"
                                      label="财务报账类型">
                        <template slot-scope="scope">
                            {{scope.row.caiwubaozhangValue}}
                        </template>
                    </el-table-column>
                    <el-table-column :sortable="contents.tableSortable" :align="contents.tableAlign" prop="caiwubaozhangFile"
                                     header-align="center"
                                     width="200"
                                     label="报账发票">
                        <template slot-scope="scope">
                            <div v-if="scope.row.caiwubaozhangFile">
                                <a type="text" style="text-decoration:none" class="el-button" :href="scope.row.caiwubaozhangFile"  >下载</a>
                            </div>
                            <div v-else>无文件</div>
                        </template>
                    </el-table-column>

                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                   prop="caiwubaozhangJine"
                                   header-align="center"
                                   label="报账金额">
                        <template slot-scope="scope">
                            {{scope.row.caiwubaozhangJine}}
                        </template>
                    </el-table-column>

                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                   prop="insertTime"
                                   header-align="center"
                                   label="财务报账申请时间">
                        <template slot-scope="scope">
                            {{scope.row.insertTime}}
                        </template>
                    </el-table-column>
                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                      prop="caiwubaozhangGuanliYesnoTypes"
                                      header-align="center"
                                      label="管理员审核状态">
                        <template slot-scope="scope">
                            {{scope.row.caiwubaozhangGuanliYesnoValue}}
                        </template>
                    </el-table-column>
                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                      prop="caiwubaozhangGuanliYesnoText"
                                      header-align="center"
                                      label="管理员审核意见">
                        <template slot-scope="scope">
                            <span v-if="scope.row.caiwubaozhangGuanliYesnoText != null &&scope.row.caiwubaozhangGuanliYesnoText.length>10">
                                {{scope.row.caiwubaozhangGuanliYesnoText.slice(0,10)}}...
                            </span>
                            <span v-else>
                                {{scope.row.caiwubaozhangGuanliYesnoText}}
                            </span>
                        </template>
                    </el-table-column>

                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                   prop="caiwubaozhangGuanliYesnoTime"
                                   header-align="center"
                                   label="管理员审核时间">
                        <template slot-scope="scope">
                            {{scope.row.caiwubaozhangGuanliYesnoTime}}
                        </template>
                    </el-table-column>
                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                      prop="caiwubaozhangYesnoTypes"
                                      header-align="center"
                                      label="经理审核状态">
                        <template slot-scope="scope">
                            {{scope.row.caiwubaozhangYesnoValue}}
                        </template>
                    </el-table-column>
                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                      prop="caiwubaozhangYesnoText"
                                      header-align="center"
                                      label="经理审核意见">
                        <template slot-scope="scope">
                            <span v-if="scope.row.caiwubaozhangYesnoText != null &&scope.row.caiwubaozhangYesnoText.length>10">
                                {{scope.row.caiwubaozhangYesnoText.slice(0,10)}}...
                            </span>
                            <span v-else>
                                {{scope.row.caiwubaozhangYesnoText}}
                            </span>
                        </template>
                    </el-table-column>

                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                   prop="caiwubaozhangShenheTime"
                                   header-align="center"
                                   label="经理审核时间">
                        <template slot-scope="scope">
                            {{scope.row.caiwubaozhangShenheTime}}
                        </template>
                    </el-table-column>

                    <el-table-column width="300" :align="contents.tableAlign"
                                     header-align="center"
                                     label="操作">
                        <template slot-scope="scope">
                            <el-button v-if="isAuth('caiwubaozhang','查看')" type="success" icon="el-icon-tickets" size="mini" @click="addOrUpdateHandler(scope.row.id,'info')">详情</el-button>
                            <el-button v-if="isAuth('caiwubaozhang','修改')" type="primary" icon="el-icon-edit" size="mini" @click="addOrUpdateHandler(scope.row.id)">修改</el-button>

                            <el-button v-if="isAuth('caiwubaozhang','删除')" type="danger" icon="el-icon-delete" size="mini" @click="deleteHandler(scope.row.id)">删除</el-button>
                            <el-button v-if="scope.row.caiwubaozhangGuanliYesnoTypes == 1 && sessionTable=='users' " type="primary" icon="el-icon-thumb" size="mini" @click="openYesnoTypes1(scope.row.id)">管理审核</el-button>
                            <el-button v-if="scope.row.caiwubaozhangYesnoTypes == 1 && sessionTable=='jingli' " type="primary" icon="el-icon-thumb" size="mini" @click="openYesnoTypes(scope.row.id)">经理审核</el-button>

                        </template>
                    </el-table-column>
                </el-table>
                <el-pagination
                        clsss="pages"
                        :layout="layouts"
                        @size-change="sizeChangeHandle"
                        @current-change="currentChangeHandle"
                        :current-page="pageIndex"
                        :page-sizes="[10, 20, 50, 100]"
                        :page-size="Number(contents.pageEachNum)"
                        :total="totalPage"
                        :small="contents.pageStyle"
                        class="pagination-content"
                        :background="contents.pageBtnBG"
                        :style="{textAlign:contents.pagePosition==1?'left':contents.pagePosition==2?'center':'right'}"
                ></el-pagination>
            </div>
        </div>
        <!-- 添加/修改页面  将父组件的search方法传递给子组件-->
        <add-or-update v-if="addOrUpdateFlag" :parent="this" ref="addOrUpdate"></add-or-update>



        <el-dialog title="统计报表" :visible.sync="chartVisiable" width="auto">
            <el-date-picker
                    v-model="echartsDate"
                    type="year"
                    placeholder="选择年">
            </el-date-picker>
            <el-button @click="chartDialog()">查询</el-button>
            <div id="statistic" style="width:100%;height:600px;"></div>
            <span slot="footer" class="dialog-footer">
				<el-button @click="chartVisiable = false">关闭</el-button>
			</span>
        </el-dialog>

    </div>
</template>
<script>
    import AddOrUpdate from "./add-or-update";
    import styleJs from "../../../utils/style.js";
    import utilsJs from "../../../utils/utils.js";

    export default {
        data() {
        return {
            searchForm: {
                key: ""
            },
            sessionTable : "",//登录账户所在表名
            role : "",//权限
            userId:"",//当前登录人的id
    //级联表下拉框搜索条件
              bumenTypesSelectSearch : [],
              zhiweiTypesSelectSearch : [],
    //当前表下拉框搜索条件
              caiwubaozhangTypesSelectSearch : [],
              caiwubaozhangGuanliYesnoTypesSelectSearch : [],
              caiwubaozhangYesnoTypesSelectSearch : [],
            form:{
                id : null,
                yonghuId : null,
                caiwubaozhangName : null,
                caiwubaozhangTypes : null,
                caiwubaozhangFile : null,
                caiwubaozhangJine : null,
                caiwubaozhangContent : null,
                insertTime : null,
                caiwubaozhangGuanliYesnoTypes : null,
                caiwubaozhangGuanliYesnoText : null,
                caiwubaozhangGuanliYesnoTime : null,
                caiwubaozhangYesnoTypes : null,
                caiwubaozhangYesnoText : null,
                caiwubaozhangShenheTime : null,
                createTime : null,
            },
            form1:{
                id : null,
                yonghuId : null,
                caiwubaozhangName : null,
                caiwubaozhangTypes : null,
                caiwubaozhangFile : null,
                caiwubaozhangJine : null,
                caiwubaozhangContent : null,
                insertTime : null,
                caiwubaozhangGuanliYesnoTypes : null,
                caiwubaozhangGuanliYesnoText : null,
                caiwubaozhangGuanliYesnoTime : null,
                caiwubaozhangYesnoTypes : null,
                caiwubaozhangYesnoText : null,
                caiwubaozhangShenheTime : null,
                createTime : null,
            },
            dataList: [],
            pageIndex: 1,
            pageSize: 10,
            totalPage: 0,
            dataListLoading: false,
            dataListSelections: [],
            showFlag: true,
            sfshVisiable: false,
            shForm: {},
            chartVisiable: false,
            echartsDate: new Date(),//echarts的时间查询字段
            addOrUpdateFlag:false,
            contents:null,
            layouts: '',

            caiwubaozhangYesnoTypesVisible1 : false,
            caiwubaozhangYesnoTypesVisible : false,

            //导出excel
            json_fields: {
                //级联表字段
                     '员工编号': 'yonghuUuidNumber',
                     '员工姓名': 'yonghuName',
                     '员工手机号': 'yonghuPhone',
                     '员工身份证号': 'yonghuIdNumber',
                     '员工头像': 'yonghuPhoto',
                     '电子邮箱': 'yonghuEmail',
                     '部门': 'bumenTypes',
                     '职位': 'zhiweiTypes',
                //本表字段
                     '财务报账标题': "caiwubaozhangName",
                     '财务报账类型': "caiwubaozhangTypes",
                     '报账发票': "caiwubaozhangFile",
                     '报账金额': "caiwubaozhangJine",
                     '财务报账申请时间': "insertTime",
                     '管理员审核状态': "caiwubaozhangGuanliYesnoTypes",
                     '管理员审核意见': "caiwubaozhangGuanliYesnoText",
                     '管理员审核时间': "caiwubaozhangGuanliYesnoTime",
                     '经理审核状态': "caiwubaozhangYesnoTypes",
                     '经理审核意见': "caiwubaozhangYesnoText",
                     '经理审核时间': "caiwubaozhangShenheTime",
            },

            };
        },
        created() {
            this.contents = styleJs.listStyle();
            this.init();
            this.getDataList();
            this.contentStyleChange()
        },
        mounted() {
            //获取当前登录用户的信息
            this.sessionTable = this.$storage.get("sessionTable");
            debugger
            this.role = this.$storage.get("role");
            this.userId = this.$storage.get("userId");

        },
        filters: {
            htmlfilter: function (val) {
                return val.replace(/<[^>]*>/g).replace(/undefined/g,'');
            }
        },
        components: {
            AddOrUpdate,
        },
        computed: {
            getActionUrl: function() {
                return `/`+this.$base.name+`/file/upload`;
            }
        },
        methods: {
            chartDialog() {
                let _this = this;
                let params = {
                    dateFormat :"%Y", //%Y-%m
                    riqi :_this.echartsDate.getFullYear(),
                    // riqi :_this.echartsDate.getFullYear()+"-"+(_this.echartsDate.getMonth() + 1 < 10 ? '0' + (_this.echartsDate.getMonth() + 1) : _this.echartsDate.getMonth() + 1),
                    thisTable : {//当前表
                        tableName :'caiwubaozhang',//当前表表名,
                        sumColum : 'caiwubaozhang_number', //求和字段
                        date : 'insert_time',//分组日期字段
                        // string : 'caiwubaozhang_name',//分组字符串字段
                        // types : 'caiwubaozhang_types',//分组下拉框字段
                    },
                    // joinTable : {//级联表（可以不存在）
                    //     tableName :'yonghu',//级联表表名
                    //     // date : 'insert_time',//分组日期字段
                    //     string : 'yonghu_name',//分组字符串字段
                    //     // types : 'yonghu_types',//分组下拉框字段
                    // }
                }
                _this.chartVisiable = true;
                _this.$nextTick(() => {
                    var statistic = this.$echarts.init(document.getElementById("statistic"), 'macarons');
                    this.$http({
                        url: "barSum",
                        method: "get",
                        params: params
                    }).then(({data}) => {
                        if(data && data.code === 0){

                            //柱状图 求和 已成功使用
                            //start
                            let yAxisName = "数值";//根据查询数据具体改(单列要改,多列不改)
                            let xAxisName = "月份";
                            let series = [];//具体数据值
                            data.data.yAxis.forEach(function (item,index) {
                                let tempMap = {};
                                // tempMap.name= ["数值"];//根据查询数据具体改(单列要改,多列不改)
                                tempMap.name=data.data.legend[index];
                                tempMap.type='bar';
                                tempMap.data=item;
                                series.push(tempMap);

                            })

                            var option = {
                                tooltip: {
                                    trigger: 'axis',
                                    axisPointer: {
                                        type: 'cross',
                                        crossStyle: {
                                            color: '#999'
                                        }
                                    }
                                },
                                toolbox: {
                                    feature: {
                                        // dataView: { show: true, readOnly: false },  // 数据查看
                                        magicType: { show: true, type: ['line', 'bar'] },//切换图形展示方式
                                        // restore: { show: true }, // 刷新
                                        saveAsImage: { show: true }//保存
                                    }
                                },
                                legend: {
                                    data: data.data.legend//标题  可以点击导致某一列数据消失
                                },
                                xAxis: [
                                    {
                                        type: 'category',
                                        axisLabel:{interval: 0},
                                        name: xAxisName,
                                        data: data.data.xAxis,
                                        axisPointer: {
                                            type: 'shadow'
                                        }
                                    }
                                ],
                                yAxis: [
                                    {
                                        type: 'value',//不能改
                                        name: yAxisName,//y轴单位
                                        axisLabel: {
                                            formatter: '{value}' // 后缀
                                        }
                                    }
                                ],
                                series:series//具体数据
                            };
                            // 使用刚指定的配置项和数据显示图表。
                            statistic.setOption(option,true);
                            //根据窗口的大小变动图表
                            window.onresize = function () {
                                statistic.resize();
                            };
                            //end
                        }else {
                            this.$message({
                                message: "报表未查询到数据",
                                type: "success",
                                duration: 1500,
                                onClose: () => {
                                    this.search();
                                }
                            });
                        }
                    });
                });
                ////饼状图
                //_this.chartVisiable = true;
                // this.$nextTick(()=>{
                //     var statistic = this.$echarts.init(document.getElementById("statistic"),'macarons');
                //     let params = {
                //         tableName: "caiwubaozhang",
                //         groupColumn: "caiwubaozhang_types",
                //     }
                //     this.$http({
                //         url: "newSelectGroupCount",
                //         method: "get",
                //         params: params
                //     }).then(({data}) => {
                //         if (data && data.code === 0) {
                //             let res = data.data;
                //             let xAxis = [];
                //             let yAxis = [];
                //             let pArray = []
                //             var option = {};
                //             for(let i=0;i<res.length;i++){
                //                 xAxis.push(res[i].name);
                //                 yAxis.push(res[i].value);
                //                 pArray.push({
                //                     value: res[i].value,
                //                     name: res[i].name
                //                 })
                //                 option = {
                //                     title: {
                //                         text: '保险合同类型统计',
                //                         left: 'center'
                //                     },
                //                     tooltip: {
                //                         trigger: 'item',
                //                         formatter: '{b} : {c} ({d}%)'
                //                     },
                //                     series: [
                //                         {
                //                             type: 'pie',
                //                             radius: '55%',
                //                             center: ['50%', '60%'],
                //                             data: pArray,
                //                             emphasis: {
                //                                 itemStyle: {
                //                                     shadowBlur: 10,
                //                                     shadowOffsetX: 0,
                //                                     shadowColor: 'rgba(0, 0, 0, 0.5)'
                //                                 }
                //                             }
                //                         }
                //                     ]
                //                 };
                //             }
                //                 statistic.setOption(option);
                //                 window.onresize = function() {
                //                     statistic.resize();
                //                 };
                //         }
                //     });
                // })
            },
            contentStyleChange() {
                this.contentSearchStyleChange()
                this.contentBtnAdAllStyleChange()
                this.contentSearchBtnStyleChange()
                this.contentTableBtnStyleChange()
                this.contentPageStyleChange()
            },
            contentSearchStyleChange() {
                this.$nextTick(() => {
                    document.querySelectorAll('.form-content .slt .el-input__inner').forEach(el => {
                        let textAlign = 'left'
                        if(this.contents.inputFontPosition == 2)
                            textAlign = 'center'
                            if (this.contents.inputFontPosition == 3) textAlign = 'right'
                                el.style.textAlign = textAlign
                            el.style.height = this.contents.inputHeight
                            el.style.lineHeight = this.contents.inputHeight
                            el.style.color = this.contents.inputFontColor
                            el.style.fontSize = this.contents.inputFontSize
                            el.style.borderWidth = this.contents.inputBorderWidth
                            el.style.borderStyle = this.contents.inputBorderStyle
                            el.style.borderColor = this.contents.inputBorderColor
                            el.style.borderRadius = this.contents.inputBorderRadius
                            el.style.backgroundColor = this.contents.inputBgColor
                    })
                    if (this.contents.inputTitle) {
                        document.querySelectorAll('.form-content .slt .el-form-item__label').forEach(el => {
                            el.style.color = this.contents.inputTitleColor
                            el.style.fontSize = this.contents.inputTitleSize
                            el.style.lineHeight = this.contents.inputHeight
                        })
                    }
                    setTimeout(() => {
                        document.querySelectorAll('.form-content .slt .el-input__prefix').forEach(el => {
                            el.style.color = this.contents.inputIconColor
                            el.style.lineHeight = this.contents.inputHeight
                        })
                        document.querySelectorAll('.form-content .slt .el-input__suffix').forEach(el => {
                            el.style.color = this.contents.inputIconColor
                            el.style.lineHeight = this.contents.inputHeight
                        })
                        document.querySelectorAll('.form-content .slt .el-input__icon').forEach(el => {
                            el.style.lineHeight = this.contents.inputHeight
                        })
                    }, 10 )
                })
            },
            // 搜索按钮
            contentSearchBtnStyleChange() {
                this.$nextTick(() => {
                    document.querySelectorAll('.form-content .slt .el-button--success').forEach(el => {
                        el.style.height = this.contents.searchBtnHeight
                        el.style.color = this.contents.searchBtnFontColor
                        el.style.fontSize = this.contents.searchBtnFontSize
                        el.style.borderWidth = this.contents.searchBtnBorderWidth
                        el.style.borderStyle = this.contents.searchBtnBorderStyle
                        el.style.borderColor = this.contents.searchBtnBorderColor
                        el.style.borderRadius = this.contents.searchBtnBorderRadius
                        el.style.backgroundColor = this.contents.searchBtnBgColor
                    })
                })
            },
            // 新增、批量删除
            contentBtnAdAllStyleChange() {
                this.$nextTick(() => {
                    document.querySelectorAll('.form-content .ad .el-button--success').forEach(el => {
                        el.style.height = this.contents.btnAdAllHeight
                        el.style.color = this.contents.btnAdAllAddFontColor
                        el.style.fontSize = this.contents.btnAdAllFontSize
                        el.style.borderWidth = this.contents.btnAdAllBorderWidth
                        el.style.borderStyle = this.contents.btnAdAllBorderStyle
                        el.style.borderColor = this.contents.btnAdAllBorderColor
                        el.style.borderRadius = this.contents.btnAdAllBorderRadius
                        el.style.backgroundColor = this.contents.btnAdAllAddBgColor
                    })
                    document.querySelectorAll('.form-content .ad .el-button--danger').forEach(el => {
                        el.style.height = this.contents.btnAdAllHeight
                        el.style.color = this.contents.btnAdAllDelFontColor
                        el.style.fontSize = this.contents.btnAdAllFontSize
                        el.style.borderWidth = this.contents.btnAdAllBorderWidth
                        el.style.borderStyle = this.contents.btnAdAllBorderStyle
                        el.style.borderColor = this.contents.btnAdAllBorderColor
                        el.style.borderRadius = this.contents.btnAdAllBorderRadius
                        el.style.backgroundColor = this.contents.btnAdAllDelBgColor
                    })
                    document.querySelectorAll('.form-content .ad .el-button--warning').forEach(el => {
                        el.style.height = this.contents.btnAdAllHeight
                        el.style.color = this.contents.btnAdAllWarnFontColor
                        el.style.fontSize = this.contents.btnAdAllFontSize
                        el.style.borderWidth = this.contents.btnAdAllBorderWidth
                        el.style.borderStyle = this.contents.btnAdAllBorderStyle
                        el.style.borderColor = this.contents.btnAdAllBorderColor
                        el.style.borderRadius = this.contents.btnAdAllBorderRadius
                        el.style.backgroundColor = this.contents.btnAdAllWarnBgColor
                    })
                })
            },
            // 表格
            rowStyle({row, rowIndex}) {
                if (rowIndex % 2 == 1) {
                    if (this.contents.tableStripe) {
                        return {color: this.contents.tableStripeFontColor}
                    }
                } else {
                    return ''
                }
            },
            cellStyle({row, rowIndex}) {
                if (rowIndex % 2 == 1) {
                    if (this.contents.tableStripe) {
                        return {backgroundColor: this.contents.tableStripeBgColor}
                    }
                } else {
                    return ''
                }
            },
            headerRowStyle({row, rowIndex}) {
                return {color: this.contents.tableHeaderFontColor}
            },
            headerCellStyle({row, rowIndex}) {
                return {backgroundColor: this.contents.tableHeaderBgColor}
            },
            // 表格按钮
            contentTableBtnStyleChange() {
                // this.$nextTick(()=>{
                //   setTimeout(()=>{
                //     document.querySelectorAll('.table-content .tables .el-table__body .el-button--success').forEach(el=>{
                //       el.style.height = this.contents.tableBtnHeight
                //       el.style.color = this.contents.tableBtnDetailFontColor
                //       el.style.fontSize = this.contents.tableBtnFontSize
                //       el.style.borderWidth = this.contents.tableBtnBorderWidth
                //       el.style.borderStyle = this.contents.tableBtnBorderStyle
                //       el.style.borderColor = this.contents.tableBtnBorderColor
                //       el.style.borderRadius = this.contents.tableBtnBorderRadius
                //       el.style.backgroundColor = this.contents.tableBtnDetailBgColor
                //     })
                //     document.querySelectorAll('.table-content .tables .el-table__body .el-button--primary').forEach(el=>{
                //       el.style.height = this.contents.tableBtnHeight
                //       el.style.color = this.contents.tableBtnEditFontColor
                //       el.style.fontSize = this.contents.tableBtnFontSize
                //       el.style.borderWidth = this.contents.tableBtnBorderWidth
                //       el.style.borderStyle = this.contents.tableBtnBorderStyle
                //       el.style.borderColor = this.contents.tableBtnBorderColor
                //       el.style.borderRadius = this.contents.tableBtnBorderRadius
                //       el.style.backgroundColor = this.contents.tableBtnEditBgColor
                //     })
                //     document.querySelectorAll('.table-content .tables .el-table__body .el-button--danger').forEach(el=>{
                //       el.style.height = this.contents.tableBtnHeight
                //       el.style.color = this.contents.tableBtnDelFontColor
                //       el.style.fontSize = this.contents.tableBtnFontSize
                //       el.style.borderWidth = this.contents.tableBtnBorderWidth
                //       el.style.borderStyle = this.contents.tableBtnBorderStyle
                //       el.style.borderColor = this.contents.tableBtnBorderColor
                //       el.style.borderRadius = this.contents.tableBtnBorderRadius
                //       el.style.backgroundColor = this.contents.tableBtnDelBgColor
                //     })

                //   }, 50)
                // })
            },
            // 分页
            contentPageStyleChange() {
                let arr = []
                if (this.contents.pageTotal) arr.push('total')
                if (this.contents.pageSizes) arr.push('sizes')
                if (this.contents.pagePrevNext) {
                    arr.push('prev')
                    if (this.contents.pagePager) arr.push('pager')
                    arr.push('next')
                }
                if (this.contents.pageJumper) arr.push('jumper')
                this.layouts = arr.join()
                this.contents.pageEachNum = 10
            },

            init() {
            },
            search() {
                this.pageIndex = 1;
                this.getDataList();
            },
            // 获取数据列表
            getDataList() {
                this.dataListLoading = true;
                let params = {
                    page: this.pageIndex,
                    limit: this.pageSize,
                    sort: 'id',
                }

                                         
                if (this.searchForm.yonghuUuidNumber!= '' && this.searchForm.yonghuUuidNumber!= undefined) {
                    params['yonghuUuidNumber'] = '%' + this.searchForm.yonghuUuidNumber + '%'
                }
                     
                if (this.searchForm.yonghuName!= '' && this.searchForm.yonghuName!= undefined) {
                    params['yonghuName'] = '%' + this.searchForm.yonghuName + '%'
                }
                                                                                                     
                if (this.searchForm.bumenTypes!= '' && this.searchForm.bumenTypes!= undefined) {
                    params['bumenTypes'] = this.searchForm.bumenTypes
                }
                     
                if (this.searchForm.zhiweiTypes!= '' && this.searchForm.zhiweiTypes!= undefined) {
                    params['zhiweiTypes'] = this.searchForm.zhiweiTypes
                }
                                             
                if (this.searchForm.caiwubaozhangName!= '' && this.searchForm.caiwubaozhangName!= undefined) {
                    params['caiwubaozhangName'] = '%' + this.searchForm.caiwubaozhangName + '%'
                }
         
                if (this.searchForm.caiwubaozhangTypes!= '' && this.searchForm.caiwubaozhangTypes!= undefined) {
                    params['caiwubaozhangTypes'] = this.searchForm.caiwubaozhangTypes
                }
                                         
                if (this.searchForm.caiwubaozhangGuanliYesnoTypes!= '' && this.searchForm.caiwubaozhangGuanliYesnoTypes!= undefined) {
                    params['caiwubaozhangGuanliYesnoTypes'] = this.searchForm.caiwubaozhangGuanliYesnoTypes
                }
                         
                if (this.searchForm.caiwubaozhangYesnoTypes!= '' && this.searchForm.caiwubaozhangYesnoTypes!= undefined) {
                    params['caiwubaozhangYesnoTypes'] = this.searchForm.caiwubaozhangYesnoTypes
                }
                        
                params['caiwubaozhangDelete'] = 1// 逻辑删除字段 1 未删除 2 删除


                this.$http({
                    url: "caiwubaozhang/page",
                    method: "get",
                    params: params
                }).then(({data}) => {
                    if(data && data.code === 0){
                        this.dataList = data.data.list;
                        this.totalPage = data.data.total;
                    }else{
                        this.dataList = [];
                        this.totalPage = 0;
                    }
                    this.dataListLoading = false;
                });

                //查询级联表搜索条件所有列表
                this.$http({
                    url: "dictionary/page?dicCode=bumen_types&page=1&limit=100",
                    method: "get",
                    page: 1,
                    limit: 100,
                }).then(({data}) => {
                    if(data && data.code === 0){
                        this.bumenTypesSelectSearch = data.data.list;
                    }
                });
                this.$http({
                    url: "dictionary/page?dicCode=zhiwei_types&page=1&limit=100",
                    method: "get",
                    page: 1,
                    limit: 100,
                }).then(({data}) => {
                    if(data && data.code === 0){
                        this.zhiweiTypesSelectSearch = data.data.list;
                    }
                });
                //查询当前表搜索条件所有列表
                //填充下拉框选项
                this.$http({
                    url: "dictionary/page?dicCode=caiwubaozhang_types&page=1&limit=100",
                    method: "get",
                }).then(({data}) => {
                    if(data && data.code === 0){
                        this.caiwubaozhangTypesSelectSearch = data.data.list;
                    }
                });
                //填充下拉框选项
                this.$http({
                    url: "dictionary/page?dicCode=caiwubaozhang_guanli_yesno_types&page=1&limit=100",
                    method: "get",
                }).then(({data}) => {
                    if(data && data.code === 0){
                        this.caiwubaozhangGuanliYesnoTypesSelectSearch = data.data.list;
                    }
                });
                //填充下拉框选项
                this.$http({
                    url: "dictionary/page?dicCode=caiwubaozhang_yesno_types&page=1&limit=100",
                    method: "get",
                }).then(({data}) => {
                    if(data && data.code === 0){
                        this.caiwubaozhangYesnoTypesSelectSearch = data.data.list;
                    }
                });
            },
            //每页数
            sizeChangeHandle(val) {
                this.pageSize = val;
                this.pageIndex = 1;
                this.getDataList();
            },
            // 当前页
            currentChangeHandle(val) {
                this.pageIndex = val;
                this.getDataList();
            },
            // 多选
            selectionChangeHandler(val) {
                this.dataListSelections = val;
            },
            // 添加/修改
            addOrUpdateHandler(id, type) {
                this.showFlag = false;
                this.addOrUpdateFlag = true;
                this.crossAddOrUpdateFlag = false;
                if (type != 'info') {
                    type = 'else';
                }
                this.$nextTick(() => {
                    this.$refs.addOrUpdate.init(id, type);
                });
            },
            // 下载
            download(file) {
                window.open(" ${file} ")
            },
            // 删除
            deleteHandler(id) {
                var ids = id ? [Number(id)] : this.dataListSelections.map(item => {
                    return Number(item.id);
                });

                this.$confirm(`确定进行[${id ? "删除" : "批量删除"}]操作?`, "提示", {
                    confirmButtonText: "确定",
                    cancelButtonText: "取消",
                    type: "warning"
                }).then(() => {
                    this.$http({
                        url: "caiwubaozhang/delete",
                        method: "post",
                        data: ids
                    }).then(({data}) => {
                        if(data && data.code === 0){
                            this.$message({
                                message: "操作成功",
                                type: "success",
                                duration: 1500,
                                onClose: () => {
                                    this.search();
                                }
                            });
                        }else{
                            this.$message.error(data.msg);
                        }
                    });
                });
            },
            // 导入功能上传文件成功后调用导入方法
            caiwubaozhangUploadSuccess(data){
                let _this = this;
                _this.$http({
                    url: "caiwubaozhang/batchInsert?fileName=" + data.file,
                    method: "get"
                }).then(({data}) => {
                    if(data && data.code === 0){
                        _this.$message({
                            message: "导入财务报账数据成功",
                            type: "success",
                            duration: 1500,
                            onClose: () => {
                                _this.search();
                            }
                        });
                    }else{
                        _this.$message.error(data.msg);
                    }
                });

            },
            // 导入功能上传文件失败后调用导入方法
            caiwubaozhangUploadError(data){
                this.$message.error('上传失败');
            },
            openYesnoTypes(id) {
                let _this = this;
                _this.form.id = null;
                _this.form.id = id;
                            _this.form.caiwubaozhangYesnoText = null;
                _this.form.caiwubaozhangYesnoTypes = "请选择经理审核状态";
                _this.caiwubaozhangYesnoTypesVisible = true;
            },

            caiwubaozhangYesnoTypesShenhe() {
                let _this = this;
                if(_this.form.caiwubaozhangYesnoTypes == "请选择经理审核状态"){
                    _this.$message.error("请选择经理审核状态");
                    return false;
                }
                if(_this.form.caiwubaozhangYesnoText == null || _this.form.caiwubaozhangYesnoText == ""){
                    _this.$message.error("请输入经理审核意见");
                    return false;
                }
                this.$http({
                    url:`caiwubaozhang/shenhe`,
                    method: "post",
                    data: _this.form
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.$message({
                            message: "审核成功",
                            type: "success",
                            duration: 1500,
                            onClose: () => {
                                _this.caiwubaozhangYesnoTypesVisible = false;
                                _this.search();
                            }
                        });
                    } else {
                        this.$message.error(data.msg);
                        _this.caiwubaozhangYesnoTypesVisible = false;
                    }
                });
            },


            openYesnoTypes1(id) {
                let _this = this;
                _this.form1.id = null;
                _this.form1.id = id;
                _this.form1.caiwubaozhangGuanliYesnoText = null;
                _this.form1.caiwubaozhangGuanliYesnoTypes = "请选择管理审核状态";
                _this.caiwubaozhangYesnoTypesVisible1 = true;
            },
            caiwubaozhangYesnoTypesShenhe1() {
                let _this = this;
                if(_this.form1.caiwubaozhangGuanliYesnoTypes == "请选择管理审核状态"){
                    _this.$message.error("请选择管理审核状态");
                    return false;
                }
                if(_this.form1.caiwubaozhangGuanliYesnoText == null || _this.form.caiwubaozhangGuanliYesnoText == ""){
                    _this.$message.error("请输入管理审核意见");
                    return false;
                }
                this.$http({
                    url:`caiwubaozhang/guanlishenhe`,
                    method: "post",
                    data: _this.form1
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.$message({
                            message: "审核成功",
                            type: "success",
                            duration: 1500,
                            onClose: () => {
                                _this.caiwubaozhangYesnoTypesVisible1 = false;
                                _this.search();
                            }
                        });
                    } else {
                        this.$message.error(data.msg);
                        _this.caiwubaozhangYesnoTypesVisible1 = false;
                    }
                });
            },        }
    };
</script>
<style lang="scss" scoped>
.slt {
    margin: 0 !important;
    display: flex;
  }

  .ad {
    margin: 0 !important;
    display: flex;
  }

  .pages {
    & /deep/ el-pagination__sizes{
      & /deep/ el-input__inner {
        height: 22px;
        line-height: 22px;
      }
    }
  }


  .el-button+.el-button {
    margin:0;
  }

  .tables {
	& /deep/ .el-button--success {
		height: 40px;
		color: rgba(101, 126, 253, 1);
		font-size: 14px;
		border-width: 1px;
		border-style: solid;
		border-color: rgba(101, 126, 253, 1);
		border-radius: 4px;
		background-color: #fff;
	}

	& /deep/ .el-button--primary {
		height: 40px;
		color: rgba(101, 126, 253, 1);
		font-size: 14px;
		border-width: 1px;
		border-style: solid;
		border-color: rgba(101, 126, 253, 1);
		border-radius: 4px;
		background-color: rgba(255, 255, 255, 1);
	}

	& /deep/ .el-button--danger {
		height: 40px;
		color: rgba(101, 126, 253, 1);
		font-size: 14px;
		border-width: 1px;
		border-style: solid;
		border-color: rgba(101, 126, 253, 1);
		border-radius: 4px;
		background-color: #fff;
	}

    & /deep/ .el-button {
      margin: 4px;
    }
  }</style>


