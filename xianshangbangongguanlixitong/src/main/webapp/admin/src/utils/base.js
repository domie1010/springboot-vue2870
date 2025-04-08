const base = {
    get() {
        return {
            url : "http://localhost:8080/xianshangbangongguanlixitong/",
            name: "xianshangbangongguanlixitong",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/xianshangbangongguanlixitong/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "线上办公管理系统"
        } 
    }
}
export default base
