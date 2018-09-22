package com.aranirahan.yogyawisata.presentation.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.aranirahan.yogyawisata.R
import com.aranirahan.yogyawisata.R.id.menu_sign_out
import com.aranirahan.yogyawisata.data.PreferencesManager
import com.aranirahan.yogyawisata.presentation.model.Wisata
import com.aranirahan.yogyawisata.presentation.ui.main.adapter.WisataAdapter
import com.aranirahan.yogyawisata.presentation.ui.register.RegisterActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.Task
import com.google.gson.Gson
import dagger.android.AndroidInjection
import org.jetbrains.anko.startActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@Suppress("UNREACHABLE_CODE")
class MainActivity : AppCompatActivity(), MainView {

    @Inject
    lateinit var sp: PreferencesManager

    private val tag = "MainActivity"

    lateinit var gso: GoogleSignInOptions
    lateinit var mGoogleSignInClient: GoogleSignInClient

    @Inject
    lateinit var presenter: MainPresenter
    @Inject
    lateinit var wisataAdapter: WisataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "Yogya Wisata"

        presenter.bind(this)

        setupData()

        setupGoogle()

        setupView()


    }

    private fun setupView() {
        rvWisata.layoutManager = LinearLayoutManager(this)
        rvWisata.adapter = wisataAdapter
        presenter.getWisata()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }

    override fun showProgress(progress: Boolean) {
        progressBar.visibility = if (progress) View.VISIBLE else View.GONE
    }

    override fun showMessage(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun displayWisata(wisata: List<Wisata>) {
        Log.d(tag, "wisata list ${Gson().toJsonTree(wisata)}")
        wisataAdapter.clearItem()
        wisataAdapter.addItems(wisata)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if (item?.itemId == menu_sign_out)
            mGoogleSignInClient.signOut().addOnCompleteListener { task: Task<Void> ->
                if (task.isSuccessful) {

                    val build = this.let { it1 -> AlertDialog.Builder(it1) }
                    build.setTitle("Delete Member")
                    build.setMessage("Do you want to sign out ?")
                    build.setPositiveButton("SIGN OUT") { _, _ ->

                        sp.isRegister = !sp.isRegister
                        startActivity<RegisterActivity>()
                        finish()
                    }
                    build.setNegativeButton("CANCEL", null)
                    build.create()?.show()

                }
            }
        return true
    }

    private fun setupGoogle() {
        gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.request_client_id))
                .requestEmail()
                .build()

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
    }

    private fun setupData() {
        sp = PreferencesManager(this)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        this.finish()
        moveTaskToBack(false)
    }
}