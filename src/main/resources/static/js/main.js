import Vue from 'vue'
import VueResource from 'vue-resource'
import User from 'pages/User.vue'

Vue.use(VueResource)


new Vue({
    el: '#profile',
    render: a => a(User)
})