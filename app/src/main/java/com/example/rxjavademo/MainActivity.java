package com.example.rxjavademo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import rx.Observable;
import rx.Observer;
import rx.functions.Action1;
import rx.functions.Func1;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // RxJava2.x.x
//        // 使用1
//        Observable<String> sender = Observable.create(new ObservableOnSubscribe<String>() {
//            @Override
//            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
//                e.onNext("Hi~"); // 发送数据"Hi~"
//                e.onNext("I come from China.");
//                e.onComplete();
//            }
//        });
//
//        // 使用2
//        Observable<String> sender_just = Observable.just("a1", "a2", "a3");
//
//        // 使用3
//        List<String> list = new ArrayList<>();
//        list.add("b1");
//        list.add("b2");
//        list.add("b3");
//        list.add("b4");
//        Observable<String> sender_from = Observable.fromIterable(list);
//
//        Observer<String> receiver = new Observer<String>() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(@NonNull String s) {
//                Log.d(TAG, "onNext: " + s);
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//                Log.d(TAG, "onError: ");
//            }
//
//            @Override
//            public void onComplete() {
//                Log.d(TAG, "onComplete: ");
//            }
//        };
//
//        sender.subscribe(receiver);
//
//        sender_just.subscribe(receiver);
//
//        sender_from.subscribe(receiver);

        // RxJava1.x.x
        Observable<String> sender = Observable.just("c1", "c2", "c3");
        sender.subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.d(TAG, "call: " + s);
            }
        });

        Observer<String> receiver = new Observer<String>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted: ");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: ");
            }

            @Override
            public void onNext(String s) {
                Log.d(TAG, "onNext: " + s);
            }
        };

        sender.subscribe(receiver);

        sender.map(new Func1<String, String>() {
            @Override
            public String call(String s) {
                return "Func1: " + s;
            }
        }).subscribe(receiver);

    }
}
