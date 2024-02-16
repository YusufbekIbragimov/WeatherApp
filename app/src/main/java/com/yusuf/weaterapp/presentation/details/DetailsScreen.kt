package com.yusuf.weaterapp.presentation.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.yusuf.weaterapp.R
import com.yusuf.weaterapp.utils.toCelsiusString

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(viewModel: DetailsViewModel = hiltViewModel()) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.fillMaxWidth(),
                title = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        text = buildString {
                            append(stringResource(id = R.string.app_name))
                            append(" - Hours")
                        },
                        color = Color.Black
                    )
                },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = null,
                        modifier = Modifier.clickable { viewModel.navigateBack() }
                    )
                }
            )
        }
    ) { contentPaddings ->

        LazyColumn(
            modifier = Modifier
                .padding(contentPaddings)
                .fillMaxSize()
        ) {
            if (uiState.daysList != null) {
                items(uiState.daysList!!.hoursList.size) { index ->
                    with(uiState.daysList!!.hoursList[index]) {
                        Text(
                            modifier = Modifier
                                .padding(vertical = 8.dp, horizontal = 16.dp)
                                .fillMaxWidth(),
                            text = "${this.datetime.take(5)} --> ${
                                this.temp.toCelsiusString(1).dropLast(1)
                            }",
                            color = Color.Black
                        )
                    }
                }
            }
        }

    }

}