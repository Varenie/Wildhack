package com.varenie.wildhack.Database.DAO

import android.content.ContentValues
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.varenie.wildhack.Database.Entities.FirstForm
import com.varenie.wildhack.Database.FirstFormDBHelper
import com.varenie.wildhack.Database.FirstFormDBHelper.Companion.COLUMN_about_your_hard_skills
import com.varenie.wildhack.Database.FirstFormDBHelper.Companion.COLUMN_about_your_soft_skills
import com.varenie.wildhack.Database.FirstFormDBHelper.Companion.COLUMN_action_in_conflict
import com.varenie.wildhack.Database.FirstFormDBHelper.Companion.COLUMN_camping_experience
import com.varenie.wildhack.Database.FirstFormDBHelper.Companion.COLUMN_city
import com.varenie.wildhack.Database.FirstFormDBHelper.Companion.COLUMN_consent_to_data_collection
import com.varenie.wildhack.Database.FirstFormDBHelper.Companion.COLUMN_consent_to_publish_creative
import com.varenie.wildhack.Database.FirstFormDBHelper.Companion.COLUMN_creative_material
import com.varenie.wildhack.Database.FirstFormDBHelper.Companion.COLUMN_criteria_of_choice_uni_or_job
import com.varenie.wildhack.Database.FirstFormDBHelper.Companion.COLUMN_criteria_of_volunteer_projects
import com.varenie.wildhack.Database.FirstFormDBHelper.Companion.COLUMN_date_of_birth
import com.varenie.wildhack.Database.FirstFormDBHelper.Companion.COLUMN_e_mail
import com.varenie.wildhack.Database.FirstFormDBHelper.Companion.COLUMN_eco_habit
import com.varenie.wildhack.Database.FirstFormDBHelper.Companion.COLUMN_fathest_point_in_russia
import com.varenie.wildhack.Database.FirstFormDBHelper.Companion.COLUMN_firstname
import com.varenie.wildhack.Database.FirstFormDBHelper.Companion.COLUMN_how_find_school
import com.varenie.wildhack.Database.FirstFormDBHelper.Companion.COLUMN_id
import com.varenie.wildhack.Database.FirstFormDBHelper.Companion.COLUMN_lastname
import com.varenie.wildhack.Database.FirstFormDBHelper.Companion.COLUMN_middlename
import com.varenie.wildhack.Database.FirstFormDBHelper.Companion.COLUMN_password
import com.varenie.wildhack.Database.FirstFormDBHelper.Companion.COLUMN_phone_number
import com.varenie.wildhack.Database.FirstFormDBHelper.Companion.COLUMN_profession
import com.varenie.wildhack.Database.FirstFormDBHelper.Companion.COLUMN_project_pride
import com.varenie.wildhack.Database.FirstFormDBHelper.Companion.COLUMN_socialnetwork
import com.varenie.wildhack.Database.FirstFormDBHelper.Companion.COLUMN_team_situation
import com.varenie.wildhack.Database.FirstFormDBHelper.Companion.COLUMN_the_most_important_in_job
import com.varenie.wildhack.Database.FirstFormDBHelper.Companion.COLUMN_username
import com.varenie.wildhack.Database.FirstFormDBHelper.Companion.TABLE_NAME
import kotlin.random.Random


class FirstFormDAO(val context: Context) {
    private val TAG = "MYCHECK"

    private val dbHelper = FirstFormDBHelper(context)
    private val db = dbHelper.writableDatabase

    private var cursor = db.query(TABLE_NAME, null, null, null, null, null, null)

    val indexId = cursor.getColumnIndex(COLUMN_id)
    val indexName = cursor.getColumnIndex(COLUMN_firstname)
    val indexLastName = cursor.getColumnIndex(COLUMN_lastname)
    val indexMiddleName = cursor.getColumnIndex(COLUMN_middlename)
    val indexUserName = cursor.getColumnIndex(COLUMN_username)
    val indexPassword = cursor.getColumnIndex(COLUMN_password)

    val indexBirth = cursor.getColumnIndex(COLUMN_date_of_birth)
    val indexEmail = cursor.getColumnIndex(COLUMN_e_mail)
    val indexPhone = cursor.getColumnIndex(COLUMN_phone_number)
    val indexSocialNetwork = cursor.getColumnIndex(COLUMN_socialnetwork)
    val indexCity = cursor.getColumnIndex(COLUMN_city)
    val indexProfession = cursor.getColumnIndex(COLUMN_profession)
    val indexCampingExperience = cursor.getColumnIndex(COLUMN_camping_experience)
    val indexDistanPoint = cursor.getColumnIndex(COLUMN_fathest_point_in_russia)
    val indexCriteriaOfProject  = cursor.getColumnIndex(COLUMN_criteria_of_volunteer_projects)

    val indexChoiceUniJob = cursor.getColumnIndex(COLUMN_criteria_of_choice_uni_or_job)
    val indexImportantJob = cursor.getColumnIndex(COLUMN_the_most_important_in_job)
    val indexProjectPride = cursor.getColumnIndex(COLUMN_project_pride)
    val indexEcoHabit = cursor.getColumnIndex(COLUMN_eco_habit)
    val indexTeamSituation = cursor.getColumnIndex(COLUMN_team_situation)
    val indexActionInConflict = cursor.getColumnIndex(COLUMN_action_in_conflict)
    val indexSoftSkills = cursor.getColumnIndex(COLUMN_about_your_soft_skills)

    val indexHardSkills = cursor.getColumnIndex(COLUMN_about_your_hard_skills)
    val indexCretive = cursor.getColumnIndex(COLUMN_creative_material)
    val indexIsCanPublish = cursor.getColumnIndex(COLUMN_consent_to_publish_creative)
    val indexHowFindSchool = cursor.getColumnIndex(COLUMN_how_find_school)
    val indexIsCanCollectData = cursor.getColumnIndex(COLUMN_consent_to_data_collection)

    fun addNameAndBirth(fio: String, birth: String) {
        val fioArr = fio.split(" ")
        //????????????????
        val lastName = fioArr[0]
        val firstName = fioArr[1]
        val middleName = fioArr[2]

        val values = ContentValues().apply {
            put(COLUMN_firstname, firstName)
            put(COLUMN_lastname, lastName)
            put(COLUMN_middlename, middleName)
            put(COLUMN_date_of_birth, birth)
        }

        db.insert(TABLE_NAME, null, values)

        cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)
        cursor.moveToFirst()

        val id = cursor.getInt(indexId)

        val sharedPref = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE)
            with(sharedPref.edit()) {
                putInt("FormId", id)
                apply()
            }
    }

    fun addMailSocilaPhone(id: Int, email: String, socialnetwork: String, phone: String) {
        val values = ContentValues().apply {
            put(COLUMN_e_mail, email)
            put(COLUMN_socialnetwork, socialnetwork)
            put(COLUMN_phone_number, phone)
        }

        db.update(TABLE_NAME, values, "$COLUMN_id=?", arrayOf(id.toString()))
    }

    fun addLivingPlacePrivacy(id: Int, livingPlace: String) {
        val values = ContentValues().apply {
            put(COLUMN_city, livingPlace)
        }

        db.update(TABLE_NAME, values, "$COLUMN_id=?", arrayOf(id.toString()))
    }

    fun addProfession(id: Int, profession: String) {
        val values = ContentValues().apply {
            put(COLUMN_profession, profession)
        }

        db.update(TABLE_NAME, values, "$COLUMN_id=?", arrayOf(id.toString()))
    }

    fun addPointExperience(id: Int, distantPoint: String, experience: String) {
        val values = ContentValues().apply {
            put(COLUMN_fathest_point_in_russia, distantPoint)
            put(COLUMN_camping_experience, experience)
        }

        db.update(TABLE_NAME, values, "$COLUMN_id=?", arrayOf(id.toString()))
    }

    fun addCriteriaProject(id: Int, criteria: String) {
        val values = ContentValues().apply {
            put(COLUMN_criteria_of_volunteer_projects, criteria)

        }

        db.update(TABLE_NAME, values, "$COLUMN_id=?", arrayOf(id.toString()))
    }

    fun addHardSkills(id: Int, hardSkills: String) {
        val values = ContentValues().apply {
            put(COLUMN_about_your_hard_skills, hardSkills)
        }

        db.update(TABLE_NAME, values, "$COLUMN_id=?", arrayOf(id.toString()))
    }

    fun addCreative(id: Int, creative: String) {
        val values = ContentValues().apply {
            put(COLUMN_creative_material, creative)
        }

        db.update(TABLE_NAME, values, "$COLUMN_id=?", arrayOf(id.toString()))
    }

    fun addPublish(id: Int, isPublish:String) {
        val values = ContentValues().apply {
            put(COLUMN_consent_to_publish_creative, isPublish)
        }
        db.update(TABLE_NAME, values, "$COLUMN_id=?", arrayOf(id.toString()))
    }

    fun addAboutSchool(id: Int, responce: String) {
        val values = ContentValues().apply {
            put(COLUMN_how_find_school, responce)
        }
        db.update(TABLE_NAME, values, "$COLUMN_id=?", arrayOf(id.toString()))
    }

    fun addCollectionData(id: Int, isAgree: String) {
        val values = ContentValues().apply {
            put(COLUMN_consent_to_data_collection, isAgree)
        }
        db.update(TABLE_NAME, values, "$COLUMN_id=?", arrayOf(id.toString()))
    }

    fun getForm(): FirstForm {
        cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)
        cursor.moveToFirst()

        val myId: Int = (System.currentTimeMillis() % 1_000).toInt()
        return FirstForm(
            myId,
            cursor.getString(indexName),
            cursor.getString(indexLastName),
            cursor.getString(indexMiddleName),
            "",
            "",
            cursor.getString(indexBirth),
            cursor.getString(indexEmail),
            cursor.getString(indexPhone),
            cursor.getString(indexSocialNetwork),
            cursor.getString(indexCity),
            cursor.getString(indexProfession),
            cursor.getString(indexCampingExperience),
            cursor.getString(indexDistanPoint),
            cursor.getString(indexCriteriaOfProject),
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            cursor.getString(indexHardSkills),
            cursor.getString(indexCretive),
            cursor.getString(indexIsCanPublish),
            cursor.getString(indexHowFindSchool),
            cursor.getString(indexIsCanCollectData)
        )
    }

    fun checkDB() {
        cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)
        cursor.moveToFirst()

        Log.i(TAG, cursor.getInt(indexId).toString())
        Log.i(TAG, cursor.getString(indexName))
        Log.i(TAG, cursor.getString(indexLastName))
        Log.i(TAG, cursor.getString(indexMiddleName))
        Log.i(TAG, cursor.getString(indexBirth))
//        Log.i(TAG, cursor.getString(indexEmail))
//        Log.i(TAG, cursor.getString(indexSocialNetwork))
//        Log.i(TAG, cursor.getString(indexPhone))
//        Log.i(TAG, cursor.getString(indexCity))
//        Log.i(TAG, cursor.getString(indexIsCanCollectData))
    }

}