package com.example.mk3.ticket

import com.example.mk3.ticket.log.Log_item


data class Ticket_item(val imageResource: Int, var nome: String, var livello: String,var tipo: String,var pacchetto: String,var logs:List<Log_item>)