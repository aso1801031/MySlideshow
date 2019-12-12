package jp.ac.asojuku.myslideshow


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_image.*

/**
 * A simple [Fragment] subclass.
 */
//グルーバルな変数
val IMAGE_RES_ID="IMAGE_RES_ID";
class ImageFragment : Fragment() {

    //画像のリソースIDを保持するプロパティフィールド
    private var imgResId:Int?=null;

    //フラグメント継承クラスが生成されっタイミングのイベントで呼ばれるコールバックメソッド
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //argumentsプロパティへ画像リソースidを変数へ設定する
        this.arguments?.let {
            //argumentsプロパティへ設定したBundleのインスタンスからキーワードで値を取得
            this.imgResId = it.getInt(IMAGE_RES_ID);

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image, container, false)
    }

    //companion objectを使ってクラスにstaticメソッドを実装する
    companion object{
        //staticメソッドを定義する
        fun newInstance(imageResourceId: Int):ImageFragment{
            //自分のインスタンスを生成する際の処理を以下にまとめる
            val bundle = Bundle();//バンドルクラスの変数を作る
            //バンドル変数に画像のリソースidを保存する
            bundle.putInt(IMAGE_RES_ID,imageResourceId)//キーワードと値（画像リソースid）
            //自分の方のインスタンスを作る
            val imageFragment = ImageFragment();
            //生成したインスタンスのargumentsプロパティにバンドル情報を設定しておく
            imageFragment.arguments = bundle;
            //生成したインスタンスをリターンする
            return imageFragment;

        }
    }

    //親のActivityの準備ができたら、自フラグメントのImageViewに表示する画像リソースIDを指定する
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //自フラグメントの中に配置されたImageViewに表示する画像リソースIDを指定
        this.imgResId?.let {
            this.imageView.setImageResource(it);//it(imgResId)をImageViewに設定
        }
    }
}
