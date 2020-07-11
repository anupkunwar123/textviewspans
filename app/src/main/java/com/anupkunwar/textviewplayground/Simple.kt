package com.anupkunwar.textviewplayground

import android.graphics.Color
import android.os.Bundle
import android.text.Layout
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.AlignmentSpan
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import android.text.style.StrikethroughSpan
import android.view.View

class Simple : AbstractFragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setSpan(
            SpannableStringBuilder()
                .append(("Using spans\n"))
                .append(
                    "Add color",
                    ForegroundColorSpan(Color.RED),
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
                .append("\n")
                .append(("Change Size!"), RelativeSizeSpan(2f), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                .append("\n")
                .append(
                    ("strike through!"),
                    StrikethroughSpan(),
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
                .append("\n")
                .append(
                    "Align Right",
                    AlignmentSpan.Standard(Layout.Alignment.ALIGN_OPPOSITE),
                    Spannable.SPAN_EXCLUSIVE_INCLUSIVE
                )
                .append(("\n"))
                .append(
                    "Align Left",
                    AlignmentSpan.Standard(Layout.Alignment.ALIGN_NORMAL),
                    Spannable.SPAN_EXCLUSIVE_INCLUSIVE
                )
                .append(
                    "\nAlign Center",
                    AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER),
                    Spannable.SPAN_EXCLUSIVE_INCLUSIVE
                )
        )

    }
}