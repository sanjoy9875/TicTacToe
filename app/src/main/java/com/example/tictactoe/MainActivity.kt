package com.example.tictactoe

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() ,View.OnClickListener{

    val PLAYER_O:Int = 0
    val PLAYER_X:Int = 1

    var activePlayer = PLAYER_O

    var filledPosition = arrayOf(-1,-1,-1,-1,-1,-1,-1,-1,-1)

    var isGameActive:Boolean = true

    var count = 0

    var isTrue = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvHeader.text = "O's Turn"

        btn0.setOnClickListener(this)
        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
        btn5.setOnClickListener(this)
        btn6.setOnClickListener(this)
        btn7.setOnClickListener(this)
        btn8.setOnClickListener(this)

    }

    override fun onClick(v: View?) {

        if (!isGameActive){
            return
        }

        var clickButton:Button = findViewById(v!!.id)
        var clickedTag = Integer.parseInt(v?.tag.toString())

        if (filledPosition[clickedTag] != -1){
            return
        }

        filledPosition[clickedTag] = activePlayer

        if (activePlayer==PLAYER_O){
            count++
            clickButton.text = "O"
            clickButton.background = getDrawable(android.R.color.holo_blue_bright)
            activePlayer = PLAYER_X

            tvHeader.text = "X's Turn"
        }
        else{
            count++
            clickButton.text = "X"
            clickButton.background = getDrawable(android.R.color.holo_orange_light)
            activePlayer = PLAYER_O
            tvHeader.text = "O's Turn"
        }

        checkForWin()

    }

    private fun checkForWin() {

        var winingPositions = arrayOf( intArrayOf(0, 1, 2),
                                        intArrayOf(3, 4, 5),
                                         intArrayOf(6, 7, 8),
                                          intArrayOf(0, 3, 6),
                                         intArrayOf(1, 4, 7),
                                         intArrayOf(2, 5, 8),
                                         intArrayOf(0, 4, 8),
                                        intArrayOf(2, 4, 6))


        for (i in 0..7 ){
            var val0 = winingPositions[i][0]
            var val1 = winingPositions[i][1]
            var val2 = winingPositions[i][2]



            if (filledPosition[val0]==filledPosition[val1] && filledPosition[val1]==filledPosition[val2]){

                if (filledPosition[val0] != -1){

                    isGameActive = false


                    if (filledPosition[val0]==PLAYER_O){
                        isTrue = false
                        showDialog("O is Winner")
                    }
                    else{
                        isTrue = false
                        showDialog("X is Winner")
                    }

                }
            }

        }
        if (isTrue && count==9){
            showDialog("Match Draw")

        }
    }

        private fun showDialog (text:String) {

            AlertDialog.Builder(this)
                .setTitle(text)
                .setPositiveButton("Restart", DialogInterface.OnClickListener { dialog, which ->
                    restartGame()
                })
                .setCancelable(false)
                .show()


}

    private fun restartGame() {

        tvHeader.text = "O's Turn"

        activePlayer = PLAYER_O

        filledPosition = arrayOf(-1,-1,-1,-1,-1,-1,-1,-1,-1)

        btn0.text = ""
        btn1.text = ""
        btn2.text = ""
        btn3.text = ""
        btn4.text = ""
        btn5.text = ""
        btn6.text = ""
        btn7.text = ""
        btn8.text = ""

        isGameActive = true

        btn0.background = getDrawable(android.R.color.darker_gray)
        btn1.background = getDrawable(android.R.color.darker_gray)
        btn2.background = getDrawable(android.R.color.darker_gray)
        btn3.background = getDrawable(android.R.color.darker_gray)
        btn4.background = getDrawable(android.R.color.darker_gray)
        btn5.background = getDrawable(android.R.color.darker_gray)
        btn6.background = getDrawable(android.R.color.darker_gray)
        btn7.background = getDrawable(android.R.color.darker_gray)
        btn8.background = getDrawable(android.R.color.darker_gray)

        isTrue = true

        count = 0

    }


}