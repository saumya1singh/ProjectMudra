package com.example.mudraapp


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mudraapp.ViewPagers.FragmentA
import com.example.mudraapp.ViewPagers.FragmentB
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_my_account.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass
 *
 */
class MyAccountFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_my_account, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mobile = FirebaseAuth.getInstance().currentUser?.phoneNumber.toString()
        txtmobile.text = mobile
        val mail = FirebaseAuth.getInstance().currentUser?.email.toString()
        txtemail.text = mail

        val fragmentlist= arrayListOf<Fragment>()
        fragmentlist.add(FragmentA())
        fragmentlist.add(FragmentB())
        val  pagerAdapter= com.example.mudraapp.ViewPagers.PagerAdapter(fragmentlist , fragmentManager )
        viewpager.adapter=pagerAdapter

    }

}
