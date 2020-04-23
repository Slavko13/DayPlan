<template>
 <div>
   <div>

   <div class="form-group">
    <label for="login">Ваш логин:</label>
    <input type="text" v-model="login" disabled class="as-text"  id="login" placeholder="Логин" name="login">
   </div>

   <div class="form-group">
    <label for="firstName">Ваша фамилия:</label>
       <input type="text" v-model="firstName"  disabled class="as-text" id="firstName" placeholder="Имя" name="firstName">
   </div>

    <div class="form-group">
     <label for="secondName">Ваше имя:</label>
     <input type="text" v-model="secondName"  disabled class="as-text " id="secondName" placeholder="Фамилия" name="secondName">
    </div>

        <button type="submit" class="btn btn-default" id="changeData"  @click="changeInputsToSave">Изменить данные</button>
       <button type="submit" class="btn btn-success" id="save" disabled @click="updateProfile">Обновить данные</button>
       <button type="submit" class="btn btn-danger" id="cancel"  disabled @click="cancel">Отменить</button>

   </div>
 </div>
</template>

<script>


    function changeInputsClassList(classToChange, classToFind) {
        let nodeItems = [...(document.querySelectorAll(classToFind))];
        for (var g of nodeItems) {
            g.classList.value = classToChange
            g.disabled = false
            }
        }

 export default {

  props: ['user'],
     data() {
         return {
             login: this.user.login,
             firstName: this.user.firstName,
             secondName: this.user.secondName
         }
     },
     methods: {
         cancel() {
             changeInputsClassList('as-text', '.form-control')
             document.querySelector('#changeData').disabled = false
             document.querySelector('#cancel').disabled = true
             document.querySelector('#save').disabled = true
         },
         changeInputsToSave() {

             changeInputsClassList('form-control', '.as-text')
             document.querySelector('#changeData').disabled = true
             document.querySelector('#cancel').disabled = false
             document.querySelector('#save').disabled = false


      },
         updateProfile() {
             let user = {firstName: this.firstName, secondName: this.secondName, login: this.login, id: this.user.id}
             this.$resource('/updateUser').save({}, user).then(result => result.json().then (
                 data => {
                     this.login = data.login
                     this.firstName = data.firstName
                     this.secondName = data.secondName
                     changeInputsClassList('as-text', '.form-control')

                     document.querySelector('#changeData').disabled = false
                     document.querySelector('#cancel').disabled = true
                     document.querySelector('#save').disabled = true

                 })
             )
         }
     }
 }
</script>

<style >
</style>