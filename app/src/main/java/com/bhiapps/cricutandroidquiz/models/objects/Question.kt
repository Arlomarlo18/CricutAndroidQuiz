package com.bhiapps.cricutandroidquiz.models.objects

sealed class Question {
    data class MultipleChoice(
        val question: String,
        val options: List<String>,
        val answer: List<String>,
    ): Question()

    data class SingleChoice(
        val question: String,
        val options: List<String>,
        val answer: String,
    ): Question()

    data class BooleanChoice(
        val question: String,
        val answer: Boolean,
    ): Question()

    data class FillInTheBlank(
        val question: String,
        val answer: String,
    ): Question()
}

fun loadQuestions(): List<Question> {
    return listOf(
        Question.MultipleChoice(
            question = "Which functions are part of the Activity Lifecycle?",
            options = listOf("onCreate", "onStartAgain", "onPause", "onDelete"),
            answer = listOf("onCreate","onPause")
        ),
        Question.SingleChoice(
            question = "Where are classes stored in Android?",
            options = listOf("Heap", "Stack", "Ram", "On the disk"),
            answer = "Heap"
        ),
        Question.BooleanChoice(
            question = "Composable are views in Jetpack Compose.",
            answer = true
        ),
        Question.FillInTheBlank(
            question = "The ___________ method is called when the activity is first created.",
            answer = "onCreate"
        ),
        Question.MultipleChoice(
            question = "What does configuration change mean?",
            options = listOf("Changing the device's language", "Turning on the Camera", "Changing the device's orientation", "All of the above"),
            answer = listOf("Changing the device's language", "Changing the device's orientation")
        ),
        Question.SingleChoice(
            question = "What does the acronym MVVM stand for?",
            options = listOf("Model View ViewModel", "Money Victory ViewModel", "Manager Views Views Manager", "Model View ViewManager"),
            answer = "Model View ViewModel"
        ),
        Question.BooleanChoice(
            question = "Coroutines are used for asynchronous programming in Kotlin.",
            answer = true
        ),
        Question.FillInTheBlank(
            question = "You can store key-value pairs in a ___________ in Android.",
            answer = "Map"
        )
    )
}