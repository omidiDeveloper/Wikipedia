package com.example.wikipedia.adapter

import com.example.wikipedia.data.ItemPost

interface itemEvent {
    fun onItemClicked(itemPost: ItemPost){

    }
}