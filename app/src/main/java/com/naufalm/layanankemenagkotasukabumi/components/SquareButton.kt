package com.naufalm.layanankemenagkotasukabumi.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.naufalm.layanankemenagkotasukabumi.ui.theme.jakartaSansFontFamily

@Composable
fun SquareButton(
    title: String,
    image: Painter,
    onClick: () -> Unit
) {
    FilledTonalButton(
        onClick = onClick,
        modifier = Modifier
            .size(width = 80.dp, height = 80.dp),
        colors = ButtonDefaults.filledTonalButtonColors(containerColor = Color.White.copy(alpha = 0f)),
        shape = RoundedCornerShape(15.dp),
        contentPadding = PaddingValues(0.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier
                    .size(35.dp),
                painter = image,
                contentDescription = null
            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                modifier = Modifier.height(30.dp),
                text = title,
                fontFamily = jakartaSansFontFamily,
                fontWeight = FontWeight.Normal,
                lineHeight = 13.sp,
                maxLines = 2,
                color = Color.Black,
                fontSize = 9.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}