package com.hussainalmahdi.android.challenge

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hussainalmahdi.android.challenge.RemoteSource.Senator
import com.hussainalmahdi.android.challenge.viewModel.SenatorsListViewModel
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var senatorsRecyclerView: RecyclerView
    private val senatorsListViewModel: SenatorsListViewModel by lazy {
        ViewModelProviders.of(this).get(SenatorsListViewModel::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        senatorsRecyclerView =findViewById(R.id.list_recycler_view)
        senatorsRecyclerView.layoutManager = LinearLayoutManager(this)

        senatorsListViewModel.senatorsListLiveData.observe(
        this, { senators->
                senatorsRecyclerView.adapter = SenatorAdapter(senators)
            }
        )

    }


    private inner class SenatorsHolder(view: View) : RecyclerView.ViewHolder(view),
        View.OnClickListener {
        private lateinit var senator:Senator
        val nameTextView :TextView = itemView.findViewById(R.id.senator_name)
        val partyTextView :TextView = itemView.findViewById(R.id.senator_party)
        val descriptionTextView :TextView = itemView.findViewById(R.id.senator_description)
        val partyImageView :ImageView = itemView.findViewById(R.id.party_icon)





        init {
            itemView.setOnClickListener(this)
        }

        fun senatorInit(senator: Senator) {
            this.senator =senator
        }

        override fun onClick(v: View) {

            val intent = Intent(this@MainActivity, DetailActivity::class.java).apply {
                putExtra("firstname",senator.person.firstname)
                putExtra("lastname",senator.person.lastname)
                putExtra("link",senator.person.link)
                putExtra("birthday",senator.person.birthday)
                putExtra("gender",senator.person.gender)
                putExtra("bioguideid",senator.person.bioguideid)
                putExtra("sortname",senator.person.sortname)
                putExtra("description",senator.description)
                putExtra("party",senator.party)
                putExtra("name",senator.person.name)
                putExtra("website",senator.website)
                putExtra("address",senator.extra.address)
                putExtra("office",senator.extra.office)
                putExtra("enddate",senator.enddate)

            }
            startActivity(intent)

        }
    }

    private inner class SenatorAdapter(var senators: List<Senator>) : RecyclerView.Adapter<SenatorsHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
                : SenatorsHolder {
            val view = layoutInflater.inflate(R.layout.list_item, parent, false)
            return SenatorsHolder(view)
        }

        override fun getItemCount() =senators.size




        @SuppressLint("SetTextI18n")
        override fun onBindViewHolder(holder: SenatorsHolder, position: Int) {
            val senator = senators[position]
            holder.apply {
                senatorInit(senator)
                nameTextView.text = senator.person.name
                partyTextView.text =senator.party
                descriptionTextView.text =senator.description
                if(senator.party == "Democrat"){
                Glide.with(partyImageView).load(R.drawable.donkey).circleCrop().into(partyImageView)}
                else {
                    Glide.with(partyImageView).load(R.drawable.elephant).circleCrop().into(partyImageView)
                }
            }

        }

    }


}