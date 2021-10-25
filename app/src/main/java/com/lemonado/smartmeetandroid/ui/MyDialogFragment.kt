package com.lemonado.smartmeetandroid.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.lemonado.smartmeetandroid.R


object MyDialogFragment :DialogFragment()  {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog!!.setTitle("Title!")
        return inflater.inflate(R.layout.test_layout, null)
    }

}