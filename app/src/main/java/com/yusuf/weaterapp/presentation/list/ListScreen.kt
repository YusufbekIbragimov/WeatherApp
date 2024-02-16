package com.yusuf.weaterapp.presentation.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.yusuf.weaterapp.R
import com.yusuf.weaterapp.utils.toCelsiusString

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(viewModel: ListViewModel = hiltViewModel()) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.fillMaxWidth(),
                title = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        text = stringResource(id = R.string.app_name),
                        color = Color.Black
                    )
                }
            )
        }
    ) { contentPaddings ->

        Column(modifier = Modifier.padding(contentPaddings)) {
            Column(modifier = Modifier.weight(1f)) {
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Today: ${uiState.today}",
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Current Time: ${uiState.time}",
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = uiState.currentTemp ?: "",
                    fontSize = 48.sp,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    repeat(uiState.filters.size) { index ->
                        with(uiState.filters[index]) {
                            ChipBox(
                                filter = this,
                                isSelected = this == uiState.activeFilter,
                                setFilter = { viewModel.setFilter(uiState.filters[index]) }
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                        }
                    }
                }
                Spacer(modifier = Modifier.weight(1f))
            }

            LazyColumn(modifier = Modifier.weight(1f)) {
                items(uiState.daysList.size) { index ->
                    with(uiState.daysList[index]) {
                        WeatherItem(
                            onClick = { viewModel.openDetails(this.datetime) },
                            this.datetime,
                            this.tempmin.toCelsiusString(),
                            this.tempmax.toCelsiusString()
                        )
                    }
                }
            }

        }
    }

}

@Composable
fun WeatherItem(
    onClick: () -> Unit = {},
    datetime: String,
    tempMin: String,
    tempMax: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .padding(vertical = 8.dp, horizontal = 16.dp),
            text = datetime,
            color = Color.Black
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            modifier = Modifier
                .padding(vertical = 8.dp, horizontal = 16.dp),
            text = "$tempMin --> $tempMax",
            color = Color.Black
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ChipBox(
    isSelected: Boolean,
    setFilter: () -> Unit,
    filter: Int
) {
    FilterChip(
        selected = isSelected,
        onClick = setFilter,
        label = {
            Text(
                text = "$filter Days",
                color = Color.Black
            )
        }
    )
}
