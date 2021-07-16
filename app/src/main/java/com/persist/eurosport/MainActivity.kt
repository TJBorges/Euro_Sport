package com.persist.eurosport

import android.graphics.Color
import android.os.Bundle
import android.provider.DocumentsContract
import android.sax.RootElement
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.persist.eurosport.adapter.TeamAdapter
import com.persist.eurosport.domain.Team
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.reflect.Method

class MainActivity : AppCompatActivity() {
    private var teamAdapter: TeamAdapter? = null
    private var linearLayoutManager: LinearLayoutManager? = null
    private var teamList = arrayListOf<Team>(
        Team(R.drawable.bd_belgica, "Belgica"),
        Team(R.drawable.bd_espanha, "Espanha"),
        Team(R.drawable.bd_inglaterra, "Inglaterra"),
        Team(R.drawable.bd_italia, "Italia"),
        Team(R.drawable.bd_suica, "Suiça"),
        Team(R.drawable.bd_turquia, "Turquia"),
        Team(R.drawable.bd_ucrania, "Ucrania")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initList()

        var color = getProp("persist.radio.fsg_reload_on","1")

        if (color == "1") {
            window.decorView.setBackgroundColor(Color.BLUE)
        }
        else {
            window.decorView.setBackgroundColor(Color.YELLOW)
        }

    }

    fun getProp(key: String?, defaultValue: String?): String? {
        var value = defaultValue
        try {
            val c = Class.forName("android.os.SystemProperties")
            val get: Method = c.getMethod("get", String::class.java, String::class.java)
            value = get.invoke(c, key, "unknown") as String?
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            return value
        }
    }

    private fun initList(){
        teamAdapter = TeamAdapter(teamList, this, this::onSetItemClickListener)
        linearLayoutManager = LinearLayoutManager(this)
        rvTeams.layoutManager = linearLayoutManager
        rvTeams.adapter = teamAdapter
    }

    fun onSetItemClickListener(team: Team){
//        val intentBook = Intent(this, BookActivity::class.java).apply {
//            flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
//            putExtra(BOOK_ACTIVITY_OBJECT_BOOK, book)
//        }
//        startActivityForResult(intentBook, BOOK_ACTIVITY_EDT_BOOK)
    }
}