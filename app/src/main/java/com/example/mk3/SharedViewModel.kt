package com.example.mk3

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel() {
    lateinit var fragment_calendar: Fragment
    lateinit var fragment_home: Fragment
    lateinit var fragment_ticket: Fragment
    lateinit var fragment_forecast: Fragment
    lateinit var fragment_help: Fragment
    lateinit var fragment_equipment: Fragment
    lateinit var fragment_segnaposto: Fragment
}