<template>
    <div class="text-center" style="padding:50px 0">
        <div class="logo">登录</div>
        <div class="login-form-1">
            <div id="login-form" class="text-left">
                <div class="login-form-main-message"></div>
                <div class="main-login-form">
                    <div class="login-group">
                        <div class="form-group">
                            <label for="lg_username" class="sr-only"></label>
                            <input type="password" class="form-control" v-model="key" placeholder="请输入密码..." @keyup.enter="login">
                        </div>
                    </div>
                    <button class="login-button" @click="login"><i class="glyphicon glyphicon-chevron-right"></i></button>
                </div>
            </div>
        </div>
    </div>
    
</template>

<script>
export default {
    name: 'login',
    data() {
        return {
            key: '',
            websocket:""
        }
    },
    methods: {
        login: function() {
            this.$http.post('login', {
                key:this.key
            }).then( (res) => {
                var identity = res.body.identity
                this.redirectBasedOnIdentity(identity)
            })
            
        },
        redirectBasedOnIdentity:function(identity){
            window.localStorage.setItem('identity', identity)
                if(identity == 'police'){
                    window.location.href = "#/working/by-number"
                }else {
                    window.location.href = "#/"
                }
        }
    },
    computed:{
        currentTime: function(){
            return new Date()
        }
    },
    mounted:function(){
    	this.websocket = new WebSocket("ws://localhost:8090/identity");

    	this.websocket.onopen = function(){
    		console.info("connected identity")
    	}

    	this.websocket.onmessage = (msg) =>{
    		console.info(msg)
    		var infor = JSON.parse(msg.data)
    		window.localStorage.setItem('identity', infor.identity)
    		if(infor.identity == 'prison'){
    			window.location.href = "#/working/detail/" + infor.code;
    		}else if(infor.identity == 'police'){
				window.location.href = "#/working/by-number"
    		}
    	}
    }
}

</script>
<style scoped>
a {
    color: #aaaaaa;
    transition: all ease-in-out 200ms;
}

a:hover {
    color: #333333;
    text-decoration: none;
}


/*=== 4. Main Form ===*/

.login-form-1 {
    max-width: 300px;
    border-radius: 5px;
    display: inline-block;
}

.main-login-form {
    position: relative;
}

.login-form-1 .form-control {
    border: 0;
    box-shadow: 0 0 0;
    border-radius: 0;
    background: transparent;
    color: #555555;
    padding: 7px 0;
    font-weight: bold;
    height: auto;
}

.login-form-1 .form-control::-webkit-input-placeholder {
    color: #999999;
}

.login-form-1 .form-control:-moz-placeholder,
.login-form-1 .form-control::-moz-placeholder,
.login-form-1 .form-control:-ms-input-placeholder {
    color: #999999;
}

.login-form-1 .form-group {
    margin-bottom: 0;
    border-bottom: 2px solid #efefef;
    padding-right: 20px;
    position: relative;
}

.login-form-1 .form-group:last-child {
    border-bottom: 0;
}

.login-group {
    background: #ffffff;
    color: #999999;
    border-radius: 8px;
    padding: 10px 20px;
}

.login-group-checkbox {
    padding: 5px 0;
}


/*=== 5. Login Button ===*/

.login-form-1 .login-button {
    position: absolute;
    right: -25px;
    top: 50%;
    background: #ffffff;
    color: #999999;
    padding: 11px 0;
    width: 50px;
    height: 50px;
    margin-top: -25px;
    border: 5px solid #efefef;
    border-radius: 50%;
    transition: all ease-in-out 500ms;
}

.login-form-1 .login-button:hover {
    color: #555555;
    transform: rotate(450deg);
}

.login-form-1 .login-button.clicked {
    color: #555555;
}

.login-form-1 .login-button.clicked:hover {
    transform: none;
}

.login-form-1 .login-button.clicked.success {
    color: #2ecc71;
}

.login-form-1 .login-button.clicked.error {
    color: #e74c3c;
}


/*=== 6. Form Invalid ===*/

label.form-invalid {
    position: absolute;
    top: 0;
    right: 0;
    z-index: 5;
    display: block;
    margin-top: -25px;
    padding: 7px 9px;
    background: #777777;
    color: #ffffff;
    border-radius: 5px;
    font-weight: bold;
    font-size: 11px;
}

label.form-invalid:after {
    top: 100%;
    right: 10px;
    border: solid transparent;
    content: " ";
    height: 0;
    width: 0;
    position: absolute;
    pointer-events: none;
    border-color: transparent;
    border-top-color: #777777;
    border-width: 6px;
}


/*=== 7. Form - Main Message ===*/

.login-form-main-message {
    background: #ffffff;
    color: #999999;
    border-left: 3px solid transparent;
    border-radius: 3px;
    margin-bottom: 8px;
    font-weight: bold;
    height: 0;
    padding: 0 20px 0 17px;
    opacity: 0;
    transition: all ease-in-out 200ms;
}

.login-form-main-message.show {
    height: auto;
    opacity: 1;
    padding: 10px 20px 10px 17px;
}

.login-form-main-message.success {
    border-left-color: #2ecc71;
}

.login-form-main-message.error {
    border-left-color: #e74c3c;
}

.logo {
    padding: 15px 0;
    font-size: 25px;
    color: #aaaaaa;
    font-weight: bold;
}
</style>
