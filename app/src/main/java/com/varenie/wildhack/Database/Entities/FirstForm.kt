package com.varenie.wildhack.Database.Entities



data class FirstForm(
    val _id: Int,
    val firstname: String,
    val lastname: String,
    val middlename: String,
    val username: String = "",
    val password: String = "",

    val date_of_birth: String,
    val e_mail: String,
    val phone_number: String,
    val socialnetwork: String,
    val city: String,
    val profession: String,
    val camping_experience: String,
    val fathest_point_in_russia: String,
    val criteria_of_volunteer_projects: String,

    val criteria_of_choice_uni_or_job: String,
    val the_most_important_in_job: String,
    val project_pride: String,
    val eco_habit: String,
    val team_situation: String,
    val action_in_conflict: String,
    val about_your_soft_skills: String,

    val about_your_hard_skills: String,
    val creative_material: String,
    val consent_to_publish_creative: Boolean,
    val how_find_school: String,
    val consent_to_data_collection: String
)
