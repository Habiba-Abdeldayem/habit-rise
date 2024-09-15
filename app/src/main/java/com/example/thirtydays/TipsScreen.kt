package com.example.thirtydays

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.ThirtyDaysTheme
import com.example.thirtydays.data.Tips
import com.example.thirtydays.model.Tip


@Composable
fun TipsList(contentPaddingValues: PaddingValues = PaddingValues(16.dp)){
    LazyColumn(contentPadding = contentPaddingValues,
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.padding_medium))
            .fillMaxWidth()){
        items(Tips){
            TipCard(tip = it)
            Spacer(modifier =  Modifier.height(8.dp))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TipCard(tip:Tip){
    var expanded by remember{ mutableStateOf(false) }

    Card ( modifier = Modifier
        .fillMaxWidth()
        .animateContentSize(
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioLowBouncy,
                stiffness = Spring.StiffnessMedium
            )
        ),
        onClick = {expanded = !expanded}){
        TipInfo(tipDayNumber = tip.dayNumber, tipTitle = tip.title, tipImage = tip.imageResourceId)
        if(expanded){
            Text(text = stringResource(id = tip.description),modifier=Modifier.padding(
                dimensionResource(id = R.dimen.padding_small)))
        }
    }
}

@Composable
fun TipInfo(tipDayNumber: Int, tipTitle: Int , tipImage: Int, modifier: Modifier = Modifier){
    Column (modifier = modifier.padding(dimensionResource(id = R.dimen.padding_small))

        ){
        Text(text = "Day $tipDayNumber", style = MaterialTheme.typography.titleSmall)
        Text(stringResource(id = tipTitle), style = MaterialTheme.typography.displaySmall)
        Image(painter = painterResource(tipImage), contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp))

    }
}

@Preview (showBackground = true)
@Composable
fun tipsPreview(){
    ThirtyDaysTheme {
        TipsList()
    }
}