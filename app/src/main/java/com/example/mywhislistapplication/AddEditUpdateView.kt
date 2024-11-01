package com.example.mywhislistapplication
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.mywhislistapplication.data.Wish
import kotlinx.coroutines.launch


@Composable
fun AddEditDetailView(
    id:Long,
    viewModel: WishViewModel,
    navController: NavController
)
{
    val snackMessage = remember{
        mutableStateOf("")
    }

    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()

    if(id !=0L){
        val wish = viewModel.getAWishById(id).collectAsState(initial = Wish(0L,"",""))
        viewModel.WishTitleState = wish.value.title
        viewModel.WishDescriptionState =wish.value.description
    }
    else
    {
        viewModel.WishTitleState = ""
        viewModel.WishDescriptionState = ""
    }
    Scaffold(
        topBar = {
            AppBarView(
                title = if(id != 0L) stringResource(id = R.string.update_wish)
                else stringResource(id = R.string.add_wish),
                {navController.navigateUp()}
            )
        },
        scaffoldState = scaffoldState
    ) {
        Column(modifier = Modifier
            .padding(it)
            .wrapContentSize() ,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
            ) {
            Spacer(modifier = Modifier.height(10.dp))

            WishTextField(label = "Title",
                value =viewModel.WishTitleState,
                onValueChange = {viewModel.onWishTitleChanged(it)})

            Spacer(modifier = Modifier.height(10.dp))

            WishTextField(label = "Description",
                value =viewModel.WishDescriptionState,
                onValueChange = {viewModel.onWishDescriptionChanged(it)})

            Spacer(modifier = Modifier.height(40.dp))
            
            Button(onClick = {
                if(viewModel.WishTitleState.isNotEmpty()&&
                    viewModel.WishDescriptionState.isNotEmpty()){
                    if(id != 0L){
                            viewModel.updateWish(
                                Wish(
                                id = id,
                                title = viewModel.WishTitleState.trim(),
                                description = viewModel.WishDescriptionState.trim()
                                )
                            )
                    }
                    else{
                        viewModel.addWish(Wish(
                            title = viewModel.WishTitleState.trim(),
                            description = viewModel.WishDescriptionState.trim()
                        ))
                        snackMessage.value = "Wish Added Successfully"
                    }

                }
                else{
                    snackMessage.value ="Enter fields to create a wish"

                }
                scope.launch {
                    navController.navigateUp()
                }
            },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(red = 204, green = 255, blue = 204)),
                shape = RoundedCornerShape(10.dp)
            )
            {
                Text(if(id != 0L) stringResource(id = R.string.update_wish)
                else stringResource(id = R.string.add_wish),
                    style = TextStyle(
                        fontSize = 18.sp
                    ),
                    color = Color.White
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
        label={ Text(text = label)},
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.Black,
            focusedBorderColor = colorResource(id = R.color.background),
            unfocusedBorderColor = colorResource(id = R.color.background),
            focusedLabelColor = colorResource(id = R.color.background),
            unfocusedLabelColor = colorResource(id = R.color.background),
            cursorColor = colorResource(id = R.color.background)
        )
    )
}