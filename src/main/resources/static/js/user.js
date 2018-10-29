new Vue({
    el:"#app",
    data:{
        user:{
            id:"",
            username:"",
            password:"",
            age:"",
            sex:"",
            email:""
        },
        userList:[]
    },
        methods:{
            findAll:function () {
                var _this=this;
                axios.get('/user/findAll')
                    .then(function (response) {
                        _this.userList=response.data;//响应数据给userList赋值
                        console.log(response);
                    })
                    .catch(function (error) {
                        // handle error
                        console.log(error);
                    });
            },
            findById:function (id) {
                var _this=this;
                axios.get('/user/findById',{params:{id:id}})
                    .then(function (response) {
                        _this.user=response.data;//响应数据给userList赋值
                        $("#myModal").modal("show");
                    })
                    .catch(function (error) {
                        console.log(error);
                    });
            },
            update:function (user) {
                var _this=this;
                axios.post('/user/update',_this.user)
                    .then(function (response) {
                        _this.findAll();
                    })
                    .catch(function (error) {

                    });
        }
    },
    created:function () {   //当页面加载的时候触发请求查询所有
        this.findAll();
    }
})