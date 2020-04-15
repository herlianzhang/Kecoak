package com.example.kecoa.model

import java.io.Serializable

data class KecoaModel(val name: String, val image: List<Int>, val desc: String, val scientific: String ,val order: String, val classification: String, val rank: String, val species: String, val kingdom: String) : Serializable