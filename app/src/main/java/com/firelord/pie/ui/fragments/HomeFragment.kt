package com.firelord.pie.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.firelord.pie.R
import com.firelord.pie.databinding.FragmentHomeBinding
import com.github.mikephil.charting.components.XAxis.XAxisPosition
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet
import com.github.mikephil.charting.utils.ColorTemplate
import java.util.*
import kotlin.collections.ArrayList


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    var year = 0
    var month = 0

    var monDay = 0
    var tueDay = 0
    var wedDay = 0
    var thurDay = 0
    var friDay = 0
    var satDay = 0
    var sunDay = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)


        val years = listOf(1970..2032).flatten()
        val yearsAdapter = ArrayAdapter(requireContext(), R.layout.list_item, years)
        (binding.etYearEdit as? AutoCompleteTextView)?.setAdapter(yearsAdapter)

        val months = listOf(
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"
        )
        val monthsAdapter = ArrayAdapter(requireContext(), R.layout.list_item, months)
        (binding.etMonthEdit as? AutoCompleteTextView)?.setAdapter(monthsAdapter)

        // Year Listener
        (binding.etYearEdit as? AutoCompleteTextView)?.onItemClickListener =
            OnItemClickListener { adapterView, view, i, l ->
                year = years[i]
                calculateDaysCount()
                drawChart()
            }

        // Month listener
        (binding.etMonthEdit as? AutoCompleteTextView)?.onItemClickListener =
            OnItemClickListener { adapterView, view, i, l ->
                month = i+1
                Log.i("monthCount:","$month")
                calculateDaysCount()
                drawChart()
            }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        drawChart()
    }

    fun drawChart() {
        // Chart setup here
        val chart = binding.barChart

        chart.description.isEnabled = false

        // if more than 60 entries are displayed in the chart, no values will be
        // drawn
        chart.setMaxVisibleValueCount(10)

        // scaling can now only be done on x- and y-axis separately
        chart.setPinchZoom(false)

        chart.setDrawBarShadow(false)
        chart.setDrawGridBackground(false)

        val xAxis = chart.xAxis
        xAxis.position = XAxisPosition.BOTTOM
        xAxis.setDrawGridLines(false)

        chart.axisLeft.setDrawGridLines(false)

        // add a nice and smooth animation
        chart.animateY(1500)

        chart.legend.isEnabled = false

        val values = ArrayList<BarEntry>()

        values.add(BarEntry(1.toFloat(), monDay.toFloat()))  // Monday
        values.add(BarEntry(2.toFloat(), tueDay.toFloat()))  // Tuesday
        values.add(BarEntry(3.toFloat(), wedDay.toFloat()))  // Wednesday
        values.add(BarEntry(4.toFloat(), thurDay.toFloat()))  // Thursday
        values.add(BarEntry(5.toFloat(), friDay.toFloat()))  // Friday
        values.add(BarEntry(6.toFloat(), satDay.toFloat()))  // Saturday
        values.add(BarEntry(7.toFloat(), sunDay.toFloat()))  // Sunday

        val set1: BarDataSet

        if (chart.data != null &&
            chart.data.dataSetCount > 0
        ) {
            set1 = chart.data.getDataSetByIndex(0) as BarDataSet
            set1.values = values
            chart.data.notifyDataChanged()
            chart.notifyDataSetChanged()
        } else {
            set1 = BarDataSet(values, "Data Set")
            set1.setColors(*ColorTemplate.VORDIPLOM_COLORS)
            set1.setDrawValues(false)
            val dataSets = java.util.ArrayList<IBarDataSet>()
            dataSets.add(set1)
            val data = BarData(dataSets)
            chart.data = data
            chart.setFitBars(true)
        }

        chart.invalidate()

    }

    fun calculateDaysCount() {
        monDay = countDayOccurence(year,month,1)
        tueDay = countDayOccurence(year,month,2)
        wedDay = countDayOccurence(year,month,3)
        thurDay = countDayOccurence(year,month,4)
        friDay = countDayOccurence(year,month,5)
        satDay = countDayOccurence(year,month,6)
        sunDay = countDayOccurence(year,month,7)

    }

    fun countDayOccurence(year: Int, month: Int, dayToFindCount: Int): Int {
        val calendar = Calendar.getInstance()
        // Note that month is 0-based in calendar, bizarrely.
        calendar[year, month - 1] = 1
        val daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        var count = 0
        for (day in 1..daysInMonth) {
            calendar[year, month - 1] = day
            val dayOfWeek = calendar[Calendar.DAY_OF_WEEK]
            if (dayOfWeek == dayToFindCount) {
                count++
            }
        }
        return count
    }
}