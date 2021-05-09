package com.example.mk3.ticket.log

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mk3.R
import com.example.mk3.SharedViewModel
import com.example.mk3.ticket.Ticket_adapter
import com.example.mk3.ticket.Ticket_item
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_ticket.*
import kotlinx.android.synthetic.main.fragment_ticket_detail.*
import kotlinx.android.synthetic.main.log_item.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment_ticketDetail.newInstance] factory method to
 * create an instance of this fragment.
 */

class Fragment_ticketDetail(ticketItem: Ticket_item) : Fragment(R.layout.fragment_ticket_detail) ,LogAdapter.OnItemClickListener{
        val ticketItem=ticketItem


    private val sharedViewModel: SharedViewModel by activityViewModels()
    private val exampleList = ticketItem.logs
    private val adapter = LogAdapter(exampleList, this)

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        nome_detail_tv.text=ticketItem.nome
        pacchetto_detail_tv.text=ticketItem.pacchetto
        livello_detail_tv.text=ticketItem.livello
        tipo_detail_tv.text=ticketItem.tipo
        recycler_view_log.adapter = adapter
        recycler_view_log.layoutManager = LinearLayoutManager(activity)
        recycler_view_log.setHasFixedSize(true)

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onItemClick(position: Int) {
        note_et.setText("sas")
    }


}