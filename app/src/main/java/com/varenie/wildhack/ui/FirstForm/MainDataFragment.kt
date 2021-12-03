package com.varenie.wildhack.ui.FirstForm

import android.app.DatePickerDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.google.android.material.textfield.TextInputEditText
import com.varenie.wildhack.R
import com.varenie.wildhack.databinding.FragmentMainDataBinding
import java.text.SimpleDateFormat
import java.util.*

class MainDataFragment : Fragment() {

    private var _binding: FragmentMainDataBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    val sdf = SimpleDateFormat("dd/MM/YYYY")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMainDataBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val etFio = binding.etFio
        val etDate = binding.etDateOfBirth

        val tw = setTextWatcher(etDate)
        etDate.addTextChangedListener(tw)

        val btnNext = binding.btnSaveAndNext

        btnNext.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_navigation_main_data_to_navigation_connect)
        }

        return root
    }

    private fun setTextWatcher(dateEditText: EditText): TextWatcher {
        val tw = object: TextWatcher {

            override fun beforeTextChanged(charSequence: CharSequence?, i: Int, i1: Int, i2: Int) {}

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                var charSequence = charSequence
                if (charSequence.length > 10) {
                    charSequence = charSequence.subSequence(0, 10)
                    dateEditText.removeTextChangedListener(this)
                    dateEditText.setText(charSequence)
                    dateEditText.addTextChangedListener(this)
                }
            }

            override fun afterTextChanged(editable: Editable) {
                val SEPERATOR: Char = '/'

                var currText = editable.toString()
                if (currText.isEmpty()) return
                val separatorCount: Int = getOcurrence(currText, SEPERATOR)
                if (currText[currText.length - 1] == SEPERATOR) {
                    return
                }
                val lastSeperatorPos: Int = currText.lastIndexOf(SEPERATOR)
                var previousTxt: String? = null
                if (lastSeperatorPos > -1) {
                    previousTxt = currText.substring(0, lastSeperatorPos + 1)
                    Log.d("curr text", currText)
                    currText = currText.substring(lastSeperatorPos + 1)
                }
                //баг с симовлом конца строки
                if (!currText.isNullOrBlank()) {
                    when (separatorCount) {
                        0 -> {
                            val date = currText.toInt()
                            if (date < 0 || date > 31) {
                                dateEditText.setError("Введите корректную дату")
                                return
                            }
                            if (currText.length == 2 || date >= 4) {
                                currText =
                                    java.lang.String.format(Locale.getDefault(), "%02d", date)
                                currText += SEPERATOR
                            }
                        }
                        1 -> {
                            val month = currText.toInt()
                            if (month < 0 || month > 31) {
                                dateEditText.setError("Введите корректную дату")
                                return
                            }
                            if (currText.length == 2 || month >= 2) {
                                currText =
                                    java.lang.String.format(Locale.getDefault(), "%02d", month)
                                currText += SEPERATOR
                            }
                        }
                        2 -> {
                            val year = currText.toInt()
                            if (year < 0) {
                                dateEditText.setError("Введите корректную дату")
                                return
                            }
                        }
                    }
                }
                if (previousTxt != null) {
                    currText = previousTxt + currText
                }
                dateEditText.removeTextChangedListener(this)
                dateEditText.setText(currText)
                val textLength = currText.length
                dateEditText.setSelection(textLength, textLength)
                dateEditText.addTextChangedListener(this)
            }
        }

        return tw
    }

    private fun getOcurrence(string: String, ch: Char): Int {
        var count = 0
        val len = string.length
        for (i in 0 until len) {
            if (string[i] == ch) ++count
        }
        return count
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}