package com.example.mk3.ticket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mk3.R
import com.example.mk3.SharedViewModel
import com.example.mk3.ticket.Ticket_adapter
import com.example.mk3.ticket.Ticket_item
import com.example.mk3.ticket.log.Fragment_ticketDetail
import com.example.mk3.ticket.log.Log_item
import kotlinx.android.synthetic.main.fragment_ticket.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"

private const val ARG_PARAM2 = "param2"


/**
 * A simple [Fragment] subclass.
 * Use the [fragment_ticket.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment_ticket : Fragment(R.layout.fragment_ticket), Ticket_adapter.OnItemClickListener {

    private val sharedViewModel:SharedViewModel by activityViewModels()

    private val exampleList = generateDummyList(500)
    private val adapter = Ticket_adapter(exampleList, this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(activity)
        recycler_view.setHasFixedSize(true)
        add_person.setOnClickListener{
            insertItem()
        }
    }

    fun insertItem() {
        val index = Random.nextInt(8)
        val newItem = Ticket_item(
            R.drawable.ic_question_circle,
            "Nuovo Paolo Zampieri $index",
            "A++",
            "Corso WS",
            "5h",
                    listOf(Log_item(Date(),"nessuna nota",60), Log_item(Date(),"qualche nota",60))
        )
        exampleList.add(index, newItem)
        adapter.notifyItemInserted(index)
    }
    fun removeItem(view: View) {
        val index = Random.nextInt(8)
        exampleList.removeAt(index)
        adapter.notifyItemRemoved(index)
    }
    override fun onItemClick(position: Int) {
        Toast.makeText(activity, "Item $position clicked", Toast.LENGTH_SHORT).show()
        val clickedItem = exampleList[position]
        changeFragment(Fragment_ticketDetail(clickedItem))
        adapter.notifyItemChanged(position)
    }
    fun changeFragment(fragment: Fragment){

        fragmentManager?.beginTransaction()?.apply {
            replace(R.id.fragment_fl, fragment)
            addToBackStack(null)
            commit()
        }
    }
    private fun generateDummyList(size: Int): ArrayList<Ticket_item> {
        val list = ArrayList<Ticket_item>()
        for (i in 0 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.ic_calendar
                1 -> R.drawable.ic_hammer
                else -> R.drawable.ic_cloud_sun
            }
            var listLog=listOf(
                Log_item(Date(),"nessuna nota",60),
                Log_item(Date(),"qualche nota",60)
            )
            val item = Ticket_item(drawable, "Paolo Zampieri $i", "A+","Corso WS","5h",listLog)
            list += item
        }
        return list

}

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment fragment_ticket.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment_ticket().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}