package com.raxdenstudios.preferences;

import android.content.SharedPreferences;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;
import java.util.Set;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by Angel on 20/02/2017.
 */

public class PreferencesProvider {

    private AdvancedPreferences mPreferences;

    public PreferencesProvider(AdvancedPreferences preferences) {
        mPreferences = preferences;
    }

    public Observable<Map<String, ?>> getAll() {
        return Observable.create(new Observable.OnSubscribe<Map<String, ?>>() {
            @Override
            public void call(Subscriber<? super Map<String, ?>> subscriber) {
                try {
                    subscriber.onNext(mPreferences.getAll());
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }

    public Observable<Boolean> contains(final String key) {
        return Observable.create(new Observable.OnSubscribe<Boolean>() {
            @Override
            public void call(Subscriber<? super Boolean> subscriber) {
                try {
                    subscriber.onNext(mPreferences.contains(key));
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }

    public Observable<SharedPreferences.Editor> remove(final String key) {
        return Observable.create(new Observable.OnSubscribe<SharedPreferences.Editor>() {
            @Override
            public void call(Subscriber<? super SharedPreferences.Editor> subscriber) {
                try {
                    subscriber.onNext(mPreferences.remove(key));
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }

    public Observable<SharedPreferences.Editor> clear() {
        return Observable.create(new Observable.OnSubscribe<SharedPreferences.Editor>() {
            @Override
            public void call(Subscriber<? super SharedPreferences.Editor> subscriber) {
                try {
                    subscriber.onNext(mPreferences.clear());
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }

    public Observable<Boolean> commit() {
        return Observable.create(new Observable.OnSubscribe<Boolean>() {
            @Override
            public void call(Subscriber<? super Boolean> subscriber) {
                try {
                    subscriber.onNext(mPreferences.commit());
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }

    public Observable<Boolean> apply() {
        return Observable.create(new Observable.OnSubscribe<Boolean>() {
            @Override
            public void call(Subscriber<? super Boolean> subscriber) {
                try {
                    mPreferences.apply();
                    subscriber.onNext(true);
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }

    public Observable<Integer> get(final String key, final int defaultValue) {
        return Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                try {
                    subscriber.onNext(mPreferences.get(key, defaultValue));
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }

    public Observable<Set<String>> get(final String key, final Set<String> defaultValue) {
        return Observable.create(new Observable.OnSubscribe<Set<String>>() {
            @Override
            public void call(Subscriber<? super Set<String>> subscriber) {
                try {
                    subscriber.onNext(mPreferences.get(key, defaultValue));
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }

    public Observable<String> get(final String key, final String defaultValue) {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                try {
                    subscriber.onNext(mPreferences.get(key, defaultValue));
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }

    public Observable<Boolean> get(final String key, final Boolean defaultValue) {
        return Observable.create(new Observable.OnSubscribe<Boolean>() {
            @Override
            public void call(Subscriber<? super Boolean> subscriber) {
                try {
                    subscriber.onNext(mPreferences.get(key, defaultValue));
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }

    public Observable<Long> get(final String key, final Long defaultValue) {
        return Observable.create(new Observable.OnSubscribe<Long>() {
            @Override
            public void call(Subscriber<? super Long> subscriber) {
                try {
                    subscriber.onNext(mPreferences.get(key, defaultValue));
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }

    public Observable<Float> get(final String key, final Float defaultValue) {
        return Observable.create(new Observable.OnSubscribe<Float>() {
            @Override
            public void call(Subscriber<? super Float> subscriber) {
                try {
                    subscriber.onNext(mPreferences.get(key, defaultValue));
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }

    public Observable<JSONObject> get(final String key, final JSONObject defaultValue) {
        return Observable.create(new Observable.OnSubscribe<JSONObject>() {
            @Override
            public void call(Subscriber<? super JSONObject> subscriber) {
                try {
                    subscriber.onNext(mPreferences.get(key, defaultValue));
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }

    public Observable<JSONArray> get(final String key, final JSONArray defaultValue) {
        return Observable.create(new Observable.OnSubscribe<JSONArray>() {
            @Override
            public void call(Subscriber<? super JSONArray> subscriber) {
                try {
                    subscriber.onNext(mPreferences.get(key, defaultValue));
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }
}
