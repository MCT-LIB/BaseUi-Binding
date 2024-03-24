# Keep the inflate(LayoutInflater) method
-keepclassmembers class * extends androidx.databinding.ViewDataBinding {
    static inflate(android.view.LayoutInflater);
    static inflate(android.view.LayoutInflater, android.view.ViewGroup, boolean);
}
