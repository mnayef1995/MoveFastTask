# Configuration
-optimizationpasses 2
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-dontskipnonpubliclibraryclassmembers
-dontpreverify
-verbose
-dump class_files.txt
-printseeds seeds.txt
-printusage unused.txt
-printmapping mapping.txt
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*
-allowaccessmodification

# Common
-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}
