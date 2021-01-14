package com.hussainalmahdi.android.challenge

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.hussainalmahdi.android.challenge.viewModel.SenatorsDetailViewModel
private lateinit var detailImageView:ImageView
private lateinit var detailNameTextView: TextView
private lateinit var detailBioguididdTextView :TextView
private lateinit var detailPartyTextView: TextView
private lateinit var detailAddressTextView: TextView
private lateinit var detailOfficeTextView: TextView
private lateinit var detailNameInfoTextView: TextView
private lateinit var detailBirthdayTextView: TextView
private lateinit var detailEnddateTextView: TextView
private lateinit var detailgenderoTextView: TextView
private lateinit var detailSortNameTextView: TextView
private lateinit var detailWebsiteTextView: TextView
private lateinit var senatorLinkTextView: TextView




class DetailActivity: AppCompatActivity() {
    private val senatorsDetailViewModel: SenatorsDetailViewModel by lazy {
        ViewModelProviders.of(this).get(SenatorsDetailViewModel::class.java)
    }
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


         detailImageView =findViewById(R.id.detail_imageView)
         detailNameTextView=findViewById(R.id.detail_name)
         detailBioguididdTextView =findViewById(R.id.detail_bioguididd)
         detailPartyTextView=findViewById(R.id.detail_party)
         detailAddressTextView=findViewById(R.id.detail_address)
         detailOfficeTextView=findViewById(R.id.detail_office)
         detailNameInfoTextView=findViewById(R.id.detail_name_info)
         detailBirthdayTextView=findViewById(R.id.detail_birthday)
         detailEnddateTextView=findViewById(R.id.detail_enddate)
         detailgenderoTextView=findViewById(R.id.detail_gender)
         detailSortNameTextView=findViewById(R.id.detail_sort_name)
         detailWebsiteTextView=findViewById(R.id.detail_website)
        senatorLinkTextView=findViewById(R.id.senator_link)


        senatorsDetailViewModel.detailName = intent.getStringExtra("name").toString()
        senatorsDetailViewModel.address = intent.getStringExtra("address").toString()
        senatorsDetailViewModel.firstName = intent.getStringExtra("firstname").toString()
        senatorsDetailViewModel.lastName = intent.getStringExtra("lastname").toString()
        senatorsDetailViewModel.link = intent.getStringExtra("link").toString()
        senatorsDetailViewModel.birthday = intent.getStringExtra("birthday").toString()
        senatorsDetailViewModel.gender = intent.getStringExtra("gender").toString()
        senatorsDetailViewModel.bioguideid = intent.getStringExtra("bioguideid").toString()
        senatorsDetailViewModel.sortname = intent.getStringExtra("sortname").toString()
        senatorsDetailViewModel.party = intent.getStringExtra("party").toString()
        senatorsDetailViewModel.office = intent.getStringExtra("office").toString()
        senatorsDetailViewModel.website = intent.getStringExtra("website").toString()
        senatorsDetailViewModel.phone = intent.getStringExtra("office").toString()
        senatorsDetailViewModel.enndate = intent.getStringExtra("enddate").toString()

        if( senatorsDetailViewModel.party == "Democrat"){
            Glide.with(detailImageView).load(R.drawable.donkey).circleCrop().into(detailImageView)}
        else {
            Glide.with(detailImageView).load(R.drawable.elephant).circleCrop().into(detailImageView)
        }

        detailNameTextView.text ="${senatorsDetailViewModel.firstName} ${senatorsDetailViewModel.lastName}"
        detailBioguididdTextView.text = senatorsDetailViewModel.bioguideid
        detailPartyTextView.text =senatorsDetailViewModel.party
        detailAddressTextView.text =senatorsDetailViewModel.address
        detailOfficeTextView.text =senatorsDetailViewModel.office
        detailBirthdayTextView.text=senatorsDetailViewModel.birthday
        detailgenderoTextView.text=senatorsDetailViewModel.gender
        detailSortNameTextView.text=senatorsDetailViewModel.sortname
        detailWebsiteTextView.text=senatorsDetailViewModel.website
        detailNameInfoTextView.text=senatorsDetailViewModel.detailName
        detailEnddateTextView.text =senatorsDetailViewModel.enndate
        senatorLinkTextView.text=senatorsDetailViewModel.link.substring(0,20)+"..."






    }
}