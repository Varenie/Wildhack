package com.varenie.wildhack.Database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class FirstFormDBHelper(context: Context): SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    companion object {
        val DB_NAME = "FirstForm.db"
        val DB_VERSION = 3

        val TABLE_NAME = "FirstForm"
        val COLUMN_id = "_id"
        val COLUMN_firstname = "firstName"
        val COLUMN_lastname = "lastName"
        val COLUMN_middlename = "middleName"
        val COLUMN_username = "userName"
        val COLUMN_password = "password"

        val COLUMN_date_of_birth = "dateOfBirth"
        val COLUMN_e_mail = "email"
        val COLUMN_phone_number = "phone"
        val COLUMN_socialnetwork = "socialNetwork"
        val COLUMN_city = "city"
        val COLUMN_profession = "profession"
        val COLUMN_camping_experience = "campingExperience"
        val COLUMN_fathest_point_in_russia = "distantPoint"
        val COLUMN_criteria_of_volunteer_projects  ="criteriaOfProject"

        val COLUMN_criteria_of_choice_uni_or_job = "choiceUniJob"
        val COLUMN_the_most_important_in_job = "importantJob"
        val COLUMN_project_pride = "projectPride"
        val COLUMN_eco_habit = "ecoHabit"
        val COLUMN_team_situation = "teamSituation"
        val COLUMN_action_in_conflict = "actionInConflict"
        val COLUMN_about_your_soft_skills = "softSkills"

        val COLUMN_about_your_hard_skills = "hardSkills"
        val COLUMN_creative_material = "creativeMaterial"
        val COLUMN_consent_to_publish_creative = "isCanPublish"
        val COLUMN_how_find_school = "howFindSchool"
        val COLUMN_consent_to_data_collection = "isCanCollectData"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE $TABLE_NAME (" +
                "$COLUMN_id INTEGER PRIMARY KEY," +
                "$COLUMN_firstname TEXT," +
                "$COLUMN_lastname TEXT," +
                "$COLUMN_middlename TEXT," +
                "$COLUMN_username TEXT," +
                "$COLUMN_password TEXT," +
                "$COLUMN_date_of_birth TEXT," +
                "$COLUMN_e_mail TEXT," +
                "$COLUMN_phone_number TEXT," +
                "$COLUMN_socialnetwork TEXT," +
                "$COLUMN_city TEXT," +
                "$COLUMN_profession TEXT," +
                "$COLUMN_camping_experience TEXT," +
                "$COLUMN_fathest_point_in_russia TEXT," +
                "$COLUMN_criteria_of_volunteer_projects TEXT," +
                "$COLUMN_criteria_of_choice_uni_or_job TEXT," +
                "$COLUMN_the_most_important_in_job TEXT," +
                "$COLUMN_project_pride TEXT," +
                "$COLUMN_eco_habit TEXT," +
                "$COLUMN_team_situation TEXT," +
                "$COLUMN_action_in_conflict TEXT," +
                "$COLUMN_about_your_soft_skills TEXT," +
                "$COLUMN_about_your_hard_skills TEXT," +
                "$COLUMN_creative_material TEXT," +
                "$COLUMN_consent_to_publish_creative TEXT," +
                "$COLUMN_how_find_school TEXT," +
                "$COLUMN_consent_to_data_collection TEXT);")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }
}