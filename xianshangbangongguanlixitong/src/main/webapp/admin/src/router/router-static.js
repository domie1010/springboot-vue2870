import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

     import users from '@/views/modules/users/list'
    import bumenrenming from '@/views/modules/bumenrenming/list'
    import caiwubaozhang from '@/views/modules/caiwubaozhang/list'
    import chuqin from '@/views/modules/chuqin/list'
    import dictionary from '@/views/modules/dictionary/list'
    import forum from '@/views/modules/forum/list'
    import gongwen from '@/views/modules/gongwen/list'
    import jingli from '@/views/modules/jingli/list'
    import news from '@/views/modules/news/list'
    import qingjia from '@/views/modules/qingjia/list'
    import richeng from '@/views/modules/richeng/list'
    import xinzi from '@/views/modules/xinzi/list'
    import yonghu from '@/views/modules/yonghu/list'
    import youjian from '@/views/modules/youjian/list'
    import dictionaryBumen from '@/views/modules/dictionaryBumen/list'
    import dictionaryCaiwubaozhang from '@/views/modules/dictionaryCaiwubaozhang/list'
    import dictionaryCaiwubaozhangGuanliYesno from '@/views/modules/dictionaryCaiwubaozhangGuanliYesno/list'
    import dictionaryCaiwubaozhangYesno from '@/views/modules/dictionaryCaiwubaozhangYesno/list'
    import dictionaryChuqin from '@/views/modules/dictionaryChuqin/list'
    import dictionaryForum from '@/views/modules/dictionaryForum/list'
    import dictionaryForumState from '@/views/modules/dictionaryForumState/list'
    import dictionaryGongwen from '@/views/modules/dictionaryGongwen/list'
    import dictionaryNews from '@/views/modules/dictionaryNews/list'
    import dictionaryQingjia from '@/views/modules/dictionaryQingjia/list'
    import dictionaryQingjiaGuanliYesno from '@/views/modules/dictionaryQingjiaGuanliYesno/list'
    import dictionaryQingjiaYesno from '@/views/modules/dictionaryQingjiaYesno/list'
    import dictionaryRicheng from '@/views/modules/dictionaryRicheng/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryYizuo from '@/views/modules/dictionaryYizuo/list'
    import dictionaryYoujian from '@/views/modules/dictionaryYoujian/list'
    import dictionaryZhiwei from '@/views/modules/dictionaryZhiwei/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryBumen',
        name: '部门',
        component: dictionaryBumen
    }
    ,{
        path: '/dictionaryCaiwubaozhang',
        name: '财务报账类型',
        component: dictionaryCaiwubaozhang
    }
    ,{
        path: '/dictionaryCaiwubaozhangGuanliYesno',
        name: '管理员审核状态',
        component: dictionaryCaiwubaozhangGuanliYesno
    }
    ,{
        path: '/dictionaryCaiwubaozhangYesno',
        name: '经理审核状态',
        component: dictionaryCaiwubaozhangYesno
    }
    ,{
        path: '/dictionaryChuqin',
        name: '打卡类型',
        component: dictionaryChuqin
    }
    ,{
        path: '/dictionaryForum',
        name: '帖子类型',
        component: dictionaryForum
    }
    ,{
        path: '/dictionaryForumState',
        name: '帖子状态',
        component: dictionaryForumState
    }
    ,{
        path: '/dictionaryGongwen',
        name: '公文类型',
        component: dictionaryGongwen
    }
    ,{
        path: '/dictionaryNews',
        name: '新闻类型',
        component: dictionaryNews
    }
    ,{
        path: '/dictionaryQingjia',
        name: '请假类型',
        component: dictionaryQingjia
    }
    ,{
        path: '/dictionaryQingjiaGuanliYesno',
        name: '管理员审核状态',
        component: dictionaryQingjiaGuanliYesno
    }
    ,{
        path: '/dictionaryQingjiaYesno',
        name: '经理审核状态',
        component: dictionaryQingjiaYesno
    }
    ,{
        path: '/dictionaryRicheng',
        name: '日程类型',
        component: dictionaryRicheng
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryYizuo',
        name: '已做未做',
        component: dictionaryYizuo
    }
    ,{
        path: '/dictionaryYoujian',
        name: '邮件类型',
        component: dictionaryYoujian
    }
    ,{
        path: '/dictionaryZhiwei',
        name: '职位',
        component: dictionaryZhiwei
    }


    ,{
        path: '/bumenrenming',
        name: '部门任命',
        component: bumenrenming
      }
    ,{
        path: '/caiwubaozhang',
        name: '财务报账',
        component: caiwubaozhang
      }
    ,{
        path: '/chuqin',
        name: '考勤',
        component: chuqin
      }
    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/forum',
        name: '论坛',
        component: forum
      }
    ,{
        path: '/gongwen',
        name: '公文',
        component: gongwen
      }
    ,{
        path: '/jingli',
        name: '经理',
        component: jingli
      }
    ,{
        path: '/news',
        name: '新闻信息',
        component: news
      }
    ,{
        path: '/qingjia',
        name: '请假',
        component: qingjia
      }
    ,{
        path: '/richeng',
        name: '日程',
        component: richeng
      }
    ,{
        path: '/xinzi',
        name: '薪资',
        component: xinzi
      }
    ,{
        path: '/yonghu',
        name: '员工',
        component: yonghu
      }
    ,{
        path: '/youjian',
        name: '邮件',
        component: youjian
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
