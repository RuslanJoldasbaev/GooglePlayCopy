package com.example.googleplay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.googleplay.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val rvAdapter = RVAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setMocKData()

        binding.recyclerView.adapter = rvAdapter
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )
    }

    private fun setMocKData() {
        var i = 0
        val data = mutableListOf<Item>()
        repeat(20) {
            val innerData = mutableListOf<Ad1>()
            val innerData2 = mutableListOf<Menu>()
            if (it == 0) {
                var k = 0
                repeat(5) {
                    when(k) {
                        0->{6+
                                k++
                            innerData2.add(Menu("Рекомендуем"))
                        }
                        1->{
                            k++
                            innerData2.add(Menu("Лучшее"))
                        }
                        2->{
                            k++
                            innerData2.add(Menu("Детям"))
                        }
                        3->{
                            k++
                            innerData2.add(Menu("Платные"))
                        }
                        else->{
                            k = 0
                            innerData2.add(Menu("Категории"))
                        }
                    }
                }
            } else if (it % 4 == 0 ) {
                data.add(Ad2(R.drawable.ad4_pubg,"PUBG MOBILE","Болейте вместе с Лионелем Месси!","Узнать больше"))
            } else if(it % 3 == 0) {
                var j = 0
                repeat(30) {
                    innerData.add(
                        when (j) {
                            0 -> {
                                j++
                                Ad1(
                                    R.drawable.ad3_airline_commander,
                                    R.drawable.ad3_airline_commander,
                                    i,
                                    "Name $i",
                                    "3,8* 397 МБ"
                                )
                            }
                            1 -> {
                                j++
                                Ad1(
                                    R.drawable.ad3_free_fire,
                                    R.drawable.ad3_free_fire,
                                    i,
                                    "Name $i",
                                    "4,4* 372 МБ"
                                )
                            }
                            2 -> {
                                j++
                                Ad1(
                                    R.drawable.ad3_my_talking_tom,
                                    R.drawable.ad3_my_talking_tom,
                                    i,
                                    "Name $i",
                                    "4,2* 99 МБ"
                                )
                            }
                            else -> {
                                j = 0
                                Ad1(
                                    R.drawable.ad3_traffic_rider,
                                    R.drawable.ad3_traffic_rider,
                                    i,
                                    "Name $i",
                                    "4,4* 88 МБ"
                                )
                            }
                        }
                    )
                    i++
                }
            } else if (it % 2 == 0) {
                var j = 0
                repeat(30) {
                    innerData.add(
                        when (j) {
                            0 -> {
                                j++
                                Ad1(
                                    R.drawable.ad2_angry_birds_2,
                                    R.drawable.ad2_angry_birds_2,
                                    i,
                                    "Name $i",
                                    "4,3* 260 МБ"
                                )
                            }
                            1 -> {
                                j++
                                Ad1(
                                    R.drawable.ad2_clash,
                                    R.drawable.ad2_clash,
                                    i,
                                    "Name $i",
                                    "4,6* 275 МБ"
                                )
                            }
                            2 -> {
                                j++
                                Ad1(
                                    R.drawable.ad2_minecraft,
                                    R.drawable.ad2_minecraft,
                                    i,
                                    "Name $i",
                                    "4,4* 537 МБ"
                                )
                            }
                            else -> {
                                j = 0
                                Ad1(
                                    R.drawable.ad2_subway_surfers,
                                    R.drawable.ad2_subway_surfers,
                                    i,
                                    "Name $i",
                                    "4,4* 105 МБ"
                                )
                            }
                        }
                    )
                    i++
                }
            } else {
                var j = 0
                repeat(30) {
                    innerData.add(
                        when (j) {
                            0 -> {
                                j++
                                Ad1(
                                    R.drawable.ad1_azbul,
                                    R.drawable.ad1_azbul,
                                    i,
                                    "Name $i",
                                    "3,7* 32 МБ"
                                )
                            }
                            1 -> {
                                j++
                                Ad1(
                                    R.drawable.ad1_dream_league_2022,
                                    R.drawable.ad1_dream_league_2022,
                                    i,
                                    "Name $i",
                                    "4,4* 485 МБ"
                                )
                            }
                            2 -> {
                                j++
                                Ad1(
                                    R.drawable.ad1_parking_master,
                                    R.drawable.ad1_parking_master,
                                    i,
                                    "Name $i",
                                    "4,1* 541 МБ"
                                )
                            }
                            else -> {
                                j = 0
                                Ad1(
                                    R.drawable.ad1_score_hero_2023,
                                    R.drawable.ad1_score_hero_2023,
                                    i,
                                    "Name $i",
                                    "4,5* 195 МБ"
                                )
                            }
                        }
                    )
                    i++
                }
            }
            data.add(RVItem(it, innerData))
            data.add(RVItem2(innerData2))
        }

        rvAdapter.models = data
    }
}