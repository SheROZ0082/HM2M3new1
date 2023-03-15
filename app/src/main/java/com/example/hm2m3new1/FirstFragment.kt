package com.example.hm2m3new1

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.Contacts.SettingsColumns.KEY
import android.provider.Settings.Global.getString
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.example.gallery.R
import com.example.gallery.databinding.FragmentFirstBinding
import com.example.hm2m3new1.model.model_G


class FirstFragment :Fragment(){
    private lateinit var binding: FragmentFirstBinding
    private lateinit var adapterGallery: Adapter
    private var list: ArrayList<model_G> = ArrayList()
    private var selectedList = arrayListOf<model_G>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        getUrl()
    }

    private fun getUrl() {
        list.add(
            model_G(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfNr19ZXi4kjvwPudi3jgq_I_QBO_MWvVSwQ&usqp=CAU",
                true
            )
        )
        list.add(
            model_G(
                "https://bestlifeonline.com/wp-content/uploads/sites/3/2018/02/Crocodile-Eye.jpg?quality=82&strip=all",
                true
            )
        )
        list.add(
            model_G(
                "https://a-z-animals.com/media/tiger_laying_hero_background.jpg",
                true
            )
        )
        list.add(
            model_G(
                "https://www.cbc.ca/kids/images/wild_and_wonderful_asian_animals_header_1140.jpg",
                true
            )
        )
        list.add(
            model_G(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ6QZQp4s4IKWoz0nWS1d6p5iCdP-Qge3LM0Q&usqp=CAU",
                true
            )
        )
        list.add(
            model_G(
                "https://www.iata.org/contentassets/d7c512eb9a704ba2a8056e3186a31921/cargo_live_animals_parrot.jpg?w=330&h=200&mode=crop&scale=both&v=20191213012337",
                true
            )
        )
        list.add(
            model_G(
                "https://images.ctfassets.net/9l3tjzgyn9gr/photo-165355/a4fcf6dc9e5cae625db0d9da9d6066a8/165355-single-male-elephant-in-the-masai-mara.jpg?fm=jpg&fl=progressive&q=50&w=1200",
                true
            )
        )
        list.add(
            model_G(
                "https://images.theconversation.com/files/285143/original/file-20190722-11355-1peled7.jpg?ixlib=rb-1.1.0&q=45&auto=format&w=926&fit=clip",
                true
            )
        )
        list.add(
            model_G(
                "https://a-z-animals.com/media/2021/01/Wild-Chameleon-Reptile-With-Beautiful-Colors-400x300.jpg",
                true
            )
        )
        list.add(
            model_G(
                "https://a-z-animals.com/media/2021/01/Golden-eyed-leaf-frog-400x300.jpg",
                true
            )
        )
        list.add(
            model_G(
                "https://www.blackpoolzoo.org.uk/content/dam/blk/images/discover-the-zoo/what-we-have/experiences/animals/asian-short-clawed-otter/Asian-short-clawed-otter-animals-Blackpool-Zoo-main.jpg",
                true
            )
        )
        list.add(
            model_G(
                "https://www.antarctica.gov.au/site/assets/files/45511/rs1662_the_triad.600x400.jpg",
                true
            )
        )
        list.add(
            model_G(
                "https://cdn.vox-cdn.com/thumbor/c90Lo_ptGqE6888878dWg-B8_5w=/0x0:6000x4000/1200x800/filters:focal(2185x2064:3145x3024)/cdn.vox-cdn.com/uploads/chorus_image/image/71539928/DSC00669.0.jpeg",
                true
            )
        )
        list.add(
            model_G(
                "https://columbuszoo.org/Media/columbus-zoo-aquarium/03-zoo-animals-lp_polar.jpg?sfvrsn=fa63d2a6_2&w=1280&h=840&mode=crop",
                true
            )
        )
        list.add(
            model_G(
                "https://a-z-animals.com/media/2021/01/Wild-Chameleon-Reptile-With-Beautiful-Colors-400x300.jpg",
                true
            )
        )
        list.add(
            model_G(
                "https://www.antarctica.gov.au/site/assets/files/45511/rs1662_the_triad.600x400.jpg",
                true
            )
        )
        list.add(
            model_G(
                "https://columbuszoo.org/Media/columbus-zoo-aquarium/03-zoo-animals-lp_polar.jpg?sfvrsn=fa63d2a6_2&w=1280&h=840&mode=crop",
                true
            )
        )
    }


    private fun initialize() {
        adapterGallery = Adapter(list)
        binding.rvMain.adapter = adapterGallery
        adapterGallery.clickListener = {
            if (it.isPicked) {
                selectedList.add(it)
            } else {
                selectedList.remove(it)
            }
        }
        binding.btnReady.setOnClickListener {
            var bundle = Bundle()
            bundle.putSerializable("key",selectedList)
            Log.e("ololo", "initialize: ${selectedList}", )
            findNavController().navigate(R.id.secondFragment,bundle)
        }
    }



    companion object {
        const val KEY = "key"
        const val REQUEST_KEY = 101
    }
}
