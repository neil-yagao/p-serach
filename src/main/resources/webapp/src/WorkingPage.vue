<template>
<div>
    <ul class="nav nav-tabs" v-if=" identity== 'police'">
      <li role="presentation" :class="this.$route.path.indexOf('by-number') >= 0?'active':''" title="编号搜索">
        <a href="#/working/by-number" class="btn-lg"><span class="glyphicon glyphicon-barcode" aria-hidden="true"></span></a>
      </li>
      <li role="presentation"  :class="this.$route.path.indexOf('by-time') >= 0?'active':''" title="时段搜索">
        <a href="#/working/by-time" class="btn-lg"><span class="glyphicon glyphicon-time" aria-hidden="true"></span></a>
      </li>
      <li role="presentation"  :class="this.$route.path.indexOf('data-edit') >= 0?'active':''" title="基本配置">
       <a href="#/working/data-edit" class="btn-lg"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a>
      </li>
      <li role="presentation" style="float:right" title="登出">
       <a class="btn-lg"><span class="glyphicon glyphicon-off" style="color:red" aria-hidden="true" @click="logout()"></span></a>
      </li>
    </ul>
     <router-view id="working-area" class="container-fluid"  style="margin-top:10px"></router-view>
     <footer class="text-center"><span> 当前时间：{{currentTime}}</span></footer>
</div> 
</template>
<script>
    export default {
    name: 'working-page',
    data() {
        return {
            key: '',
            currentTime: (new Date()).toLocaleString(),
            identity:window.localStorage.getItem('identity'),
            websocket:'',
            debounceToLogin:'',
            vedioRecording:false
        }
    },
    methods: {
    	logout(){
    		window.location.href = "#/";
    		window.localStorage.setItem('identity', '');
    	}
    },
    mounted: function() {
        var self = this;
        console.info('loading working page')
        setInterval(function() {
            self.currentTime = (new Date()).toLocaleString()
        }, 1000);
        this.websocket = new WebSocket("ws://localhost:8090/identity");

        this.websocket.onopen = function() {
            console.info("connected identity")
        }

        this.websocket.onmessage = (msg) => {
            var infor = JSON.parse(msg.data)
            console.info(infor)
            this.identity = infor.identity;
            window.localStorage.setItem('identity', infor.identity);
            if (infor.identity == 'prison') {
                window.location.href = "#/working/detail/" + infor.code;
            } else if (infor.identity == 'police') {
                window.location.href = "#/working/by-number"
            }
        }
    }
}
</script>
<style>
.btn-lg {
    font-size:20px;
}
.footer {
  position: relative;
  margin-top: -150px; /* negative value of footer height */
  height: 150px;
  clear:both;
  padding-top:20px;
} 
#working-area {
  min-height: 600px;
}

</style>
