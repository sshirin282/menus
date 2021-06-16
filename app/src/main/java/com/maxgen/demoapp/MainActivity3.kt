package com.maxgen.demoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*

class MainActivity3 : AppCompatActivity() {
    lateinit var button: Button
    lateinit var listView: ListView
    val  name= arrayOf<String>("rahul","khushi","arati","kajal","kiran","riya")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        button=findViewById(R.id.button)
        listView=findViewById(R.id.list)

        registerForContextMenu(button)

    val arrayAdapter=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,name)
        listView.adapter=arrayAdapter

        registerForContextMenu(listView)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.setting -> {
                Toast.makeText(applicationContext, "click on setting", Toast.LENGTH_LONG).show()
                val intent= Intent(this, MainActivity4::class.java);
                startActivity(intent)
                true

            }
            R.id.profile ->{
                Toast.makeText(applicationContext, "click on profile", Toast.LENGTH_LONG).show()
                val intent= Intent(this, MainActivity::class.java);
                startActivity(intent)
                return true
            }
            R.id.share ->{
                Toast.makeText(applicationContext, "click on share", Toast.LENGTH_LONG).show()
                val intent= Intent(this, MainActivity2::class.java);
                startActivity(intent)
                return true
            }
            R.id.exit ->{
               Toast.makeText(this, "click on exit", Toast.LENGTH_LONG).show()
                val intent= Intent(this, MainActivity::class.java);
                startActivity(intent)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = menuInflater
        inflater.inflate(R.menu.menu,menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when( item.itemId){
            R.id.setting->{
                Toast.makeText(this, "Go Setting", Toast.LENGTH_SHORT).show()
                val intent= Intent(this, MainActivity4::class.java);
                startActivity(intent)
                return true
            }
            R.id.profile-> {
                Toast.makeText(applicationContext, "Go Profile", Toast.LENGTH_SHORT).show()
                val intent= Intent(this, MainActivity::class.java);
                startActivity(intent)
                return true
            }
            R.id.share-> {
                Toast.makeText(applicationContext, "Go Share", Toast.LENGTH_SHORT).show()
                val intent= Intent(this, MainActivity4::class.java);
                startActivity(intent)
                return true
            }
            R.id.exit-> {
                Toast.makeText(applicationContext, "Go Exit", Toast.LENGTH_SHORT).show()
                val intent= Intent(this, MainActivity::class.java);
                startActivity(intent)
                return true
            }
                else -> super.onOptionsItemSelected(item)

        }

    }
}