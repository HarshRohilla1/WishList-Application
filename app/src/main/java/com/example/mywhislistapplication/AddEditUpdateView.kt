package com.example.mywhislistapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController


@Composable
fun AddEditDetailView(
    id:Long,
    viewModel: WishViewModel,
    navController: NavController
)
{
    Scaffold(
        topBar = {
            AppBarView(
                title = if(id != 0L) stringResource(id = R.string.update_wish)
                else stringResource(id = R.string.add_wish),
                {navController.navigateUp()}
            )
        }
    ) {
        Column(modifier = Modifier.padding(it),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
            ) {
            Spacer(modifier = Modifier.heightIn(10.dp))

            WishTextField(label = "Title",
                value =viewModel.WishTitleState,
                onValueChange = {viewModel.onWishTitleChanged(it)})

            Spacer(modifier = Modifier.heightIn(10.dp))

            WishTextField(label = "Description",
                value =viewModel.WishDescriptionState,
                onValueChange = {viewModel.onWishDescriptionChanged(it)})

            Spacer(modifier = Modifier.heightIn(10.dp))
            
            Button(onClick = {
                if(viewModel.WishTitleState.isNotEmpty()&&
                    viewModel.WishDescriptionState.isNotEmpty()){

                }
                else{

                }
            })
            {
                Text(if(id != 0L) stringResource(id = R.string.update_wish)
                else stringResource(id = R.string.add_wish),
                    style = TextStyle(
                        fontSize = 18.sp
                    )
                )
                
            }
        }
    }
}

@Composable
fun WishTextField(
    label:String,
    value:String,
    onValueChange:(String) -> Unit
)
{
    OutlinedTextField(
        value =value ,
        onValueChange = onValueChange,
        label={ Text(text = label,color = Color.Black)},
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.Black,
            focusedBorderColor = Color.Black,
            unfocusedBorderColor = Color.Black,
            focusedLabelColor = Color.Black,
            unfocusedLabelColor = Color.Black,
            cursorColor = Color.Black
        )
    )
}