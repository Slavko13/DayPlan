<template >
<div>

    <div class="form-group">
        <label for="userFile">Загрузите свой файл учебы или работы</label>
        <input type="file"  id="userFile" ref="file" v-on:change="handleFileUpload()" multiple>
        <input type="submit" class="btn btn-primary" value="Добавить файл" @click="submitFile">
    </div>
    <p>

    <div class="form-group">
        <label for="houseName">Дайте кличку вашему дому:</label>
        <input type="text" class="form-control" id="houseName" style="width: 600px">
    </div>

    <div class="form-group">
        <label for="address">Дайте адрес вашему дому:</label>
        <input type="text" id="address"  class="form-control" name="address" style="width: 600px"/>
    </div>
        <input type="submit" class="btn btn-primary"  value="Добавить дома">

</div>
</template>

<script>

    const axios = require('axios').default;

    export default {
        data() {
                return {
                    file: ''
                }
            },
        methods: {
            handleFileUpload(){
                this.file = this.$refs.file.files[0]
            },
            submitFile() {
                let formData = new FormData();
                formData.append('file', this.file);
                axios.post( '/upload/file',
                    formData,
                    {
                        headers: {
                            'Content-Type': 'multipart/form-data'
                        }
                    }
                ).then(data => {
                    alert(data.data)
                });
            }
        }
    }
</script>

<style>

</style>