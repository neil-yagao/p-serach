<template>
<div>
    <ul class="nav nav-tabs">
      <li role="presentation" :class="this.$route.path.indexOf('by-number') >= 0?'active':''">
        <a href="#/working/by-number" class="btn-lg"><span class="glyphicon glyphicon-barcode" aria-hidden="true"></span></a>
      </li>
      <li role="presentation" style ="float:right" :class="this.$route.path.indexOf('by-time') >= 0?'active':''">
        <a href="#/working/by-time" class="btn-lg"><span class="glyphicon glyphicon-time" aria-hidden="true"></span></a>
      </li>
      <li role="presentation" style ="float:right" :class="this.$route.path.indexOf('data-edit') >= 0?'active':''">
       <a href="#/working/data-edit" class="btn-lg"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a>
      </li>
    </ul>
     <router-view id="working-area" class="container-fluid"></router-view>
     <footer><h3 class="text-center"><small >当前时间：{{currentTime}}</small></h3></footer>
</div> 
</template>
<script>
    export default {
    name: 'working-page',
    data() {
        return {
            key: '',
            currentTime: (new Date()).toLocaleString()
        }
    },
    methods: {
    
    },
    mounted: function() {
        var self = this;

        setInterval(function() {
            self.currentTime = (new Date()).toLocaleString()
        }, 1000);
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
  padding-bottom:150px; /* this needs to be bigger than footer height*/
}
</style>
