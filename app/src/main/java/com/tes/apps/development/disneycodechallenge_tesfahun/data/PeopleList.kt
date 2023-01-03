package com.tes.apps.development.disneycodechallenge_tesfahun.data

data class PeopleList (
    var list: MutableList<People> = mutableListOf(People(""))
){

   fun getListOfPeople(): List<People>{
       var  list=mutableListOf(People(""))
       list.add(People("First person") )
       list.add(People("First person") )
       list.add(People("First person") )
       list.add(People("First person") )
       list.add(People("First person") )
       list.add(People("First person") )
       list.add(People("First person") )
       list.add(People("First person") )
       list.add(People("First person") )
       return list

}
}