package com.education.kidfunlearning.ui.statistic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.education.kidfunlearning.R

class StatisticFragment : Fragment() {

    private lateinit var statisticViewModel: StatisticViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        statisticViewModel =
                ViewModelProviders.of(this).get(StatisticViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_statistic, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        statisticViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}
