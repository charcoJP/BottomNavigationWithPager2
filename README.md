## MEMO

### FragmentStateAdapter に渡す引数による挙動の違い
#### childFragmentManager, lifecycle
カレントのタブ: onResume
それ以外のタブ: onPause
詳細に遷移したとき:
- カレント: onPause -> onStop -> onDestroyView
- それ以外: onStop -> onDestroyView
戻った時:
- カレント: onStart -> onResume
- それ以外: onStart
```
[アプリ起動]
2022-07-06 22:32:48.248: HomeFragment: onCreate: null
2022-07-06 22:32:48.254: HomeFragment: onStart
2022-07-06 22:32:48.254: HomeFragment: onResume
[DashboardFragmentタブ選択]
2022-07-06 22:32:54.896: DashboardFragment: onCreate: null
2022-07-06 22:32:54.906: DashboardFragment: onStart
2022-07-06 22:32:54.907: HomeFragment: onPause
2022-07-06 22:32:54.908: DashboardFragment: onResume
[NotificationsFragmentタブ選択]
2022-07-06 22:33:04.092: NotificationsFragment: onCreate: null
2022-07-06 22:33:04.104: NotificationsFragment: onStart
2022-07-06 22:33:04.107: DashboardFragment: onPause
2022-07-06 22:33:04.107: NotificationsFragment: onResume
[詳細に遷移]
2022-07-06 22:33:09.130: NotificationsFragment: onPause
2022-07-06 22:33:09.132: HomeFragment: onStop
2022-07-06 22:33:09.133: DashboardFragment: onStop
2022-07-06 22:33:09.134: NotificationsFragment: onStop
2022-07-06 22:33:09.190: HomeFragment: onDestroyView
2022-07-06 22:33:09.193: DashboardFragment: onDestroyView
2022-07-06 22:33:09.194: NotificationsFragment: onDestroyView
[詳細から戻る]
2022-07-06 22:33:32.608: HomeFragment: onStart
2022-07-06 22:33:32.608: DashboardFragment: onStart
2022-07-06 22:33:32.609: NotificationsFragment: onStart
2022-07-06 22:33:32.612: NotificationsFragment: onResume
```

#### childFragmentManager, viewLifecycleOwner.lifecycle
childFragmentManager, lifecycle と一緒

```
[アプリ起動]
2022-07-06 22:51:59.489: HomeFragment: onCreate: null
2022-07-06 22:51:59.494: HomeFragment: onStart
2022-07-06 22:51:59.494: HomeFragment: onResume
[DashboardFragmentタブ選択]
2022-07-06 22:52:02.321: DashboardFragment: onCreate: null
2022-07-06 22:52:02.327: DashboardFragment: onStart
2022-07-06 22:52:02.328: HomeFragment: onPause
2022-07-06 22:52:02.329: DashboardFragment: onResume
[NotificationsFragmentタブ選択]
2022-07-06 22:52:05.353: NotificationsFragment: onCreate: null
2022-07-06 22:52:05.358: NotificationsFragment: onStart
2022-07-06 22:52:05.359: DashboardFragment: onPause
2022-07-06 22:52:05.359: NotificationsFragment: onResume
[詳細に遷移]
2022-07-06 22:52:08.815: NotificationsFragment: onPause
2022-07-06 22:52:08.821: HomeFragment: onStop
2022-07-06 22:52:08.821: DashboardFragment: onStop
2022-07-06 22:52:08.821: NotificationsFragment: onStop
2022-07-06 22:52:08.870: HomeFragment: onDestroyView
2022-07-06 22:52:08.871: DashboardFragment: onDestroyView
2022-07-06 22:52:08.871: NotificationsFragment: onDestroyView
[詳細から戻る]
2022-07-06 22:52:12.756: HomeFragment: onStart
2022-07-06 22:52:12.756: DashboardFragment: onStart
2022-07-06 22:52:12.757: NotificationsFragment: onStart
2022-07-06 22:52:12.761: NotificationsFragment: onResume
```

#### Activity
カレントのタブ: onResume
それ以外のタブ: onPause
詳細に遷移したときも、戻った時も全タブのライフサイクルが動かない

```
[アプリ起動]
2022-07-06 22:37:05.973: HomeFragment: onCreate: null
2022-07-06 22:37:05.978: HomeFragment: onStart
2022-07-06 22:37:05.979: HomeFragment: onResume
[DashboardFragmentタブ選択]
2022-07-06 22:37:08.740: DashboardFragment: onCreate: null
2022-07-06 22:37:08.752: DashboardFragment: onStart
2022-07-06 22:37:08.754: HomeFragment: onPause
2022-07-06 22:37:08.755: DashboardFragment: onResume
[NotificationsFragmentタブ選択]
2022-07-06 22:37:09.610: NotificationsFragment: onCreate: null
2022-07-06 22:37:09.621: NotificationsFragment: onStart
2022-07-06 22:37:09.623: DashboardFragment: onPause
2022-07-06 22:37:09.623: NotificationsFragment: onResume
[詳細に遷移]
[詳細から戻る]
```