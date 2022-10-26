package com.milkyway.gbusiness.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00de\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u009e\u0001\u001a\u00030\u009f\u0001J\b\u0010\u00a0\u0001\u001a\u00030\u009f\u0001J\n\u0010\u00a1\u0001\u001a\u00030\u009f\u0001H\u0002J\u0013\u0010\u00a2\u0001\u001a\u00030\u009f\u00012\u0007\u0010\u00a3\u0001\u001a\u00020\u0004H\u0002J\u001b\u0010\u00a4\u0001\u001a\u00030\u009f\u00012\u0006\u0010&\u001a\u00020\n2\u0007\u0010\u00a5\u0001\u001a\u00020\nH\u0002J\u001e\u0010\u00a6\u0001\u001a\u00030\u009f\u00012\u0007\u0010\u00a7\u0001\u001a\u00020\u00042\t\b\u0002\u0010\u00a5\u0001\u001a\u00020\nH\u0002J\t\u0010\u00a8\u0001\u001a\u00020?H\u0002J\t\u0010\u00a9\u0001\u001a\u00020?H\u0002J\n\u0010\u00aa\u0001\u001a\u00030\u009f\u0001H\u0002J\u0013\u0010\u00ab\u0001\u001a\u00030\u009f\u00012\u0007\u0010\u00ac\u0001\u001a\u00020\nH\u0002J\n\u0010\u00ad\u0001\u001a\u00030\u009f\u0001H\u0002J\n\u0010\u00ae\u0001\u001a\u00030\u009f\u0001H\u0002J\n\u0010\u00af\u0001\u001a\u00030\u009f\u0001H\u0002J\n\u0010\u00b0\u0001\u001a\u00030\u009f\u0001H\u0002J\u0014\u0010\u00b1\u0001\u001a\u00030\u009f\u00012\b\u0010\u00b2\u0001\u001a\u00030\u00b3\u0001H\u0002J*\u0010\u00b4\u0001\u001a\u0012\u0012\u0004\u0012\u00020\n0.j\b\u0012\u0004\u0012\u00020\n`02\u000f\u0010\u00b5\u0001\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 H\u0002J*\u0010\u00b6\u0001\u001a\u0012\u0012\u0004\u0012\u00020\n0.j\b\u0012\u0004\u0012\u00020\n`02\u000f\u0010\u00b7\u0001\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010 H\u0002J*\u0010\u00b8\u0001\u001a\u0012\u0012\u0004\u0012\u00020\n0.j\b\u0012\u0004\u0012\u00020\n`02\u000f\u0010\u00b9\u0001\u001a\n\u0012\u0004\u0012\u00020q\u0018\u00010 H\u0002J(\u0010\u00ba\u0001\u001a\u00030\u009f\u00012\u0007\u0010\u00bb\u0001\u001a\u00020\u00042\u0007\u0010\u00bc\u0001\u001a\u00020\u00042\n\u0010\u00bd\u0001\u001a\u0005\u0018\u00010\u00be\u0001H\u0016J\u0013\u0010\u00bf\u0001\u001a\u00030\u009f\u00012\u0007\u0010\u00c0\u0001\u001a\u00020EH\u0016J.\u0010\u00c1\u0001\u001a\u0005\u0018\u00010\u00b3\u00012\b\u0010\u00c2\u0001\u001a\u00030\u00c3\u00012\n\u0010\u00c4\u0001\u001a\u0005\u0018\u00010\u00c5\u00012\n\u0010\u00c6\u0001\u001a\u0005\u0018\u00010\u00c7\u0001H\u0016J\n\u0010\u00c8\u0001\u001a\u00030\u009f\u0001H\u0016J\n\u0010\u00c9\u0001\u001a\u00030\u009f\u0001H\u0002J\u0014\u0010\u00ca\u0001\u001a\u00030\u009f\u00012\b\u0010\u00cb\u0001\u001a\u00030\u00cc\u0001H\u0002J\t\u0010\u00cd\u0001\u001a\u00020:H\u0002J\n\u0010\u00ce\u0001\u001a\u00030\u009f\u0001H\u0002J\n\u0010\u00cf\u0001\u001a\u00030\u009f\u0001H\u0002J\u0013\u0010\u00d0\u0001\u001a\u00030\u009f\u00012\u0007\u0010\u00d1\u0001\u001a\u00020\nH\u0002JG\u0010\u00d2\u0001\u001a\u00030\u009f\u00012\u0006\u0010h\u001a\u00020\u00042\u0006\u0010m\u001a\u00020\u00042\u0007\u0010\u00d3\u0001\u001a\u00020\n2\u0007\u0010\u00d4\u0001\u001a\u00020\n2\u0007\u0010\u00d5\u0001\u001a\u00020\n2\u0007\u0010\u00d6\u0001\u001a\u00020\n2\u0007\u0010\u00d7\u0001\u001a\u00020\nH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.\u00a2\u0006\u0002\n\u0000R\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010\f\"\u0004\b(\u0010\u000eR\"\u0010)\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010 X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010#\"\u0004\b,\u0010%R.\u0010-\u001a\u0016\u0012\u0004\u0012\u00020/\u0018\u00010.j\n\u0012\u0004\u0012\u00020/\u0018\u0001`0X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u000e\u00105\u001a\u000206X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000206X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000206X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020<X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010>\u001a\u00020?X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010@\"\u0004\bA\u0010BR\u000e\u0010C\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010D\u001a\u00020EX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u000e\u0010J\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R \u0010K\u001a\b\u0012\u0004\u0012\u00020L0.X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bM\u00102\"\u0004\bN\u00104R\u001a\u0010O\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u001a\u0010T\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bU\u0010Q\"\u0004\bV\u0010SR\u000e\u0010W\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010X\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Q\"\u0004\bZ\u0010SR\u001a\u0010[\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010Q\"\u0004\b]\u0010SR\u001a\u0010^\u001a\u00020_X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u000e\u0010d\u001a\u00020eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020eX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010h\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bi\u0010\u0006\"\u0004\bj\u0010kR\u000e\u0010l\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010m\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bn\u0010\u0006\"\u0004\bo\u0010kR\"\u0010p\u001a\n\u0012\u0004\u0012\u00020q\u0018\u00010 X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\br\u0010#\"\u0004\bs\u0010%R\u000e\u0010t\u001a\u00020_X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010u\u001a\u00020_X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010v\u001a\u000206X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR\u001a\u0010{\u001a\u00020<X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR\u001d\u0010\u0080\u0001\u001a\u000206X\u0086.\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u0010x\"\u0005\b\u0082\u0001\u0010zR\u001d\u0010\u0083\u0001\u001a\u000206X\u0086.\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0084\u0001\u0010x\"\u0005\b\u0085\u0001\u0010zR \u0010\u0086\u0001\u001a\u00030\u0087\u0001X\u0086.\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001d\u0010\u008c\u0001\u001a\u00020_X\u0086.\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u008d\u0001\u0010a\"\u0005\b\u008e\u0001\u0010cR\u001d\u0010\u008f\u0001\u001a\u000206X\u0086.\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0001\u0010x\"\u0005\b\u0091\u0001\u0010zR\u001d\u0010\u0092\u0001\u001a\u000206X\u0086.\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0093\u0001\u0010x\"\u0005\b\u0094\u0001\u0010zR\u001d\u0010\u0095\u0001\u001a\u00020_X\u0086.\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0096\u0001\u0010a\"\u0005\b\u0097\u0001\u0010cR\u001d\u0010\u0098\u0001\u001a\u00020_X\u0086.\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0099\u0001\u0010a\"\u0005\b\u009a\u0001\u0010cR\u001d\u0010\u009b\u0001\u001a\u000206X\u0086.\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u009c\u0001\u0010x\"\u0005\b\u009d\u0001\u0010z\u00a8\u0006\u00d8\u0001"}, d2 = {"Lcom/milkyway/gbusiness/fragments/ProfileFragment;", "Landroidx/fragment/app/Fragment;", "()V", "REQUEST_GALLERY", "", "getREQUEST_GALLERY", "()I", "REQUEST_IMAGE_CAPTURE", "getREQUEST_IMAGE_CAPTURE", "activateAccount", "", "getActivateAccount", "()Ljava/lang/String;", "setActivateAccount", "(Ljava/lang/String;)V", "btnActivateSSL", "Landroid/widget/Button;", "camerabtn", "Landroid/widget/ImageView;", "getCamerabtn", "()Landroid/widget/ImageView;", "setCamerabtn", "(Landroid/widget/ImageView;)V", "ccPicker", "Lcom/hbb20/CountryCodePicker;", "getCcPicker", "()Lcom/hbb20/CountryCodePicker;", "setCcPicker", "(Lcom/hbb20/CountryCodePicker;)V", "changePassWordCardView", "Landroidx/cardview/widget/CardView;", "cityList", "", "Lcom/milkyway/gbusiness/models/CityDataClass$City;", "getCityList", "()Ljava/util/List;", "setCityList", "(Ljava/util/List;)V", "countryCode", "getCountryCode", "setCountryCode", "countryList", "Lcom/milkyway/gbusiness/models/CountryDataClass$Country;", "getCountryList", "setCountryList", "domainArrayList", "Ljava/util/ArrayList;", "Lcom/milkyway/gbusiness/models/DomainX;", "Lkotlin/collections/ArrayList;", "getDomainArrayList", "()Ljava/util/ArrayList;", "setDomainArrayList", "(Ljava/util/ArrayList;)V", "etAddress", "Landroid/widget/EditText;", "etCity", "etZipCode", "filterPopup", "Landroid/widget/PopupWindow;", "fsvCountry", "Llibs/mjn/fieldset/FieldSetView;", "fsvState", "isTextInputLayoutClicked", "", "()Z", "setTextInputLayoutClicked", "(Z)V", "ivSelectCity", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "myProfileBack", "professionList", "Lcom/milkyway/gbusiness/models/DataXXXXX;", "getProfessionList", "setProfessionList", "profileChangePassBtn", "getProfileChangePassBtn", "()Landroid/widget/Button;", "setProfileChangePassBtn", "(Landroid/widget/Button;)V", "profileDeactiviteAccountBtn", "getProfileDeactiviteAccountBtn", "setProfileDeactiviteAccountBtn", "profileFragBtnCreatWebMail", "profileUpdateNumberBtn", "getProfileUpdateNumberBtn", "setProfileUpdateNumberBtn", "profileUserDetailsUpdateBtn", "getProfileUserDetailsUpdateBtn", "setProfileUserDetailsUpdateBtn", "profileUserName", "Landroid/widget/TextView;", "getProfileUserName", "()Landroid/widget/TextView;", "setProfileUserName", "(Landroid/widget/TextView;)V", "searchableSpinnerCity", "Lcom/leo/searchablespinner/SearchableSpinner;", "searchableSpinnerCountry", "searchableSpinnerState", "selectedCountryId", "getSelectedCountryId", "setSelectedCountryId", "(I)V", "selectedItem", "selectedStateId", "getSelectedStateId", "setSelectedStateId", "stateList", "Lcom/milkyway/gbusiness/models/StateDataClass$State;", "getStateList", "setStateList", "tvCountry", "tvState", "tvprofileNewPas", "getTvprofileNewPas", "()Landroid/widget/EditText;", "setTvprofileNewPas", "(Landroid/widget/EditText;)V", "tvprofileProfession", "getTvprofileProfession", "()Llibs/mjn/fieldset/FieldSetView;", "setTvprofileProfession", "(Llibs/mjn/fieldset/FieldSetView;)V", "tvprofilecurrentPas", "getTvprofilecurrentPas", "setTvprofilecurrentPas", "tvprofileretypePas", "getTvprofileretypePas", "setTvprofileretypePas", "userPhoto", "Lde/hdodenhof/circleimageview/CircleImageView;", "getUserPhoto", "()Lde/hdodenhof/circleimageview/CircleImageView;", "setUserPhoto", "(Lde/hdodenhof/circleimageview/CircleImageView;)V", "userProfileTvEmailId", "getUserProfileTvEmailId", "setUserProfileTvEmailId", "userProfileTvFLastName", "getUserProfileTvFLastName", "setUserProfileTvFLastName", "userProfileTvFirstName", "getUserProfileTvFirstName", "setUserProfileTvFirstName", "userProfileTvProfessionName", "getUserProfileTvProfessionName", "setUserProfileTvProfessionName", "userProfileTvUserName", "getUserProfileTvUserName", "setUserProfileTvUserName", "userProfileTvUserPhone", "getUserProfileTvUserPhone", "setUserProfileTvUserPhone", "OpenCamera", "", "OpenGallery", "activateDeactivateAccount", "callGetCitiesApi", "stateId", "callGetCountriesApi", "stateCode", "callGetStatesApi", "countryId", "checkPassValidation", "checkProfileUpdateValidation", "dismissPopup", "errorToast", "message", "getChangePassApi", "getProfessionApi", "getProfileApi", "getProfissionLayout", "initializeView", "view", "Landroid/view/View;", "loadCityNameList", "cityArrayList", "loadCountriesNameList", "countryArrayList", "loadStateNameList", "stateArrayList", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "context", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStop", "setClickListener", "setProfileData", "getData", "Lcom/milkyway/gbusiness/models/ProfileDetailaDataClass;", "showAlertFilter", "showDialog", "updateMobileNumber", "updateUserImage", "encodedString", "userProfileUpdateApi", "firstName", "lastName", "city", "zipCode", "address", "app_debug"})
public final class ProfileFragment extends androidx.fragment.app.Fragment {
    public android.content.Context mContext;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String activateAccount = "0";
    private final int REQUEST_IMAGE_CAPTURE = 2;
    private final int REQUEST_GALLERY = 3;
    @org.jetbrains.annotations.Nullable()
    private com.hbb20.CountryCodePicker ccPicker;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String countryCode = "+91";
    public android.widget.TextView userProfileTvUserName;
    public android.widget.TextView profileUserName;
    public android.widget.EditText userProfileTvFirstName;
    public android.widget.EditText userProfileTvFLastName;
    public android.widget.TextView userProfileTvProfessionName;
    public android.widget.TextView userProfileTvEmailId;
    public android.widget.EditText tvprofilecurrentPas;
    public android.widget.EditText tvprofileNewPas;
    public android.widget.EditText tvprofileretypePas;
    public android.widget.EditText userProfileTvUserPhone;
    public android.widget.Button profileUserDetailsUpdateBtn;
    public android.widget.Button profileUpdateNumberBtn;
    public android.widget.Button profileChangePassBtn;
    public android.widget.Button profileDeactiviteAccountBtn;
    public de.hdodenhof.circleimageview.CircleImageView userPhoto;
    public android.widget.ImageView camerabtn;
    private android.widget.ImageView myProfileBack;
    private androidx.cardview.widget.CardView changePassWordCardView;
    private android.widget.Button profileFragBtnCreatWebMail;
    private android.widget.Button btnActivateSSL;
    private libs.mjn.fieldset.FieldSetView fsvCountry;
    private libs.mjn.fieldset.FieldSetView fsvState;
    private android.widget.TextView tvCountry;
    private android.widget.TextView tvState;
    private android.widget.EditText etCity;
    private android.widget.ImageView ivSelectCity;
    private android.widget.EditText etZipCode;
    private android.widget.EditText etAddress;
    private com.leo.searchablespinner.SearchableSpinner searchableSpinnerCountry;
    private com.leo.searchablespinner.SearchableSpinner searchableSpinnerState;
    private com.leo.searchablespinner.SearchableSpinner searchableSpinnerCity;
    private boolean isTextInputLayoutClicked = false;
    @org.jetbrains.annotations.Nullable()
    private java.util.ArrayList<com.milkyway.gbusiness.models.DomainX> domainArrayList;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<com.milkyway.gbusiness.models.CountryDataClass.Country> countryList;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<com.milkyway.gbusiness.models.StateDataClass.State> stateList;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<com.milkyway.gbusiness.models.CityDataClass.City> cityList;
    private int selectedCountryId = 0;
    private int selectedStateId = 0;
    public libs.mjn.fieldset.FieldSetView tvprofileProfession;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.milkyway.gbusiness.models.DataXXXXX> professionList;
    private android.widget.PopupWindow filterPopup;
    private int selectedItem = -1;
    private java.util.HashMap _$_findViewCache;
    
    public ProfileFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getMContext() {
        return null;
    }
    
    public final void setMContext(@org.jetbrains.annotations.NotNull()
    android.content.Context p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getActivateAccount() {
        return null;
    }
    
    public final void setActivateAccount(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getREQUEST_IMAGE_CAPTURE() {
        return 0;
    }
    
    public final int getREQUEST_GALLERY() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.hbb20.CountryCodePicker getCcPicker() {
        return null;
    }
    
    public final void setCcPicker(@org.jetbrains.annotations.Nullable()
    com.hbb20.CountryCodePicker p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCountryCode() {
        return null;
    }
    
    public final void setCountryCode(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getUserProfileTvUserName() {
        return null;
    }
    
    public final void setUserProfileTvUserName(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getProfileUserName() {
        return null;
    }
    
    public final void setProfileUserName(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.EditText getUserProfileTvFirstName() {
        return null;
    }
    
    public final void setUserProfileTvFirstName(@org.jetbrains.annotations.NotNull()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.EditText getUserProfileTvFLastName() {
        return null;
    }
    
    public final void setUserProfileTvFLastName(@org.jetbrains.annotations.NotNull()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getUserProfileTvProfessionName() {
        return null;
    }
    
    public final void setUserProfileTvProfessionName(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getUserProfileTvEmailId() {
        return null;
    }
    
    public final void setUserProfileTvEmailId(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.EditText getTvprofilecurrentPas() {
        return null;
    }
    
    public final void setTvprofilecurrentPas(@org.jetbrains.annotations.NotNull()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.EditText getTvprofileNewPas() {
        return null;
    }
    
    public final void setTvprofileNewPas(@org.jetbrains.annotations.NotNull()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.EditText getTvprofileretypePas() {
        return null;
    }
    
    public final void setTvprofileretypePas(@org.jetbrains.annotations.NotNull()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.EditText getUserProfileTvUserPhone() {
        return null;
    }
    
    public final void setUserProfileTvUserPhone(@org.jetbrains.annotations.NotNull()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.Button getProfileUserDetailsUpdateBtn() {
        return null;
    }
    
    public final void setProfileUserDetailsUpdateBtn(@org.jetbrains.annotations.NotNull()
    android.widget.Button p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.Button getProfileUpdateNumberBtn() {
        return null;
    }
    
    public final void setProfileUpdateNumberBtn(@org.jetbrains.annotations.NotNull()
    android.widget.Button p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.Button getProfileChangePassBtn() {
        return null;
    }
    
    public final void setProfileChangePassBtn(@org.jetbrains.annotations.NotNull()
    android.widget.Button p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.Button getProfileDeactiviteAccountBtn() {
        return null;
    }
    
    public final void setProfileDeactiviteAccountBtn(@org.jetbrains.annotations.NotNull()
    android.widget.Button p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final de.hdodenhof.circleimageview.CircleImageView getUserPhoto() {
        return null;
    }
    
    public final void setUserPhoto(@org.jetbrains.annotations.NotNull()
    de.hdodenhof.circleimageview.CircleImageView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.ImageView getCamerabtn() {
        return null;
    }
    
    public final void setCamerabtn(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView p0) {
    }
    
    public final boolean isTextInputLayoutClicked() {
        return false;
    }
    
    public final void setTextInputLayoutClicked(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.ArrayList<com.milkyway.gbusiness.models.DomainX> getDomainArrayList() {
        return null;
    }
    
    public final void setDomainArrayList(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.milkyway.gbusiness.models.DomainX> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.milkyway.gbusiness.models.CountryDataClass.Country> getCountryList() {
        return null;
    }
    
    public final void setCountryList(@org.jetbrains.annotations.Nullable()
    java.util.List<com.milkyway.gbusiness.models.CountryDataClass.Country> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.milkyway.gbusiness.models.StateDataClass.State> getStateList() {
        return null;
    }
    
    public final void setStateList(@org.jetbrains.annotations.Nullable()
    java.util.List<com.milkyway.gbusiness.models.StateDataClass.State> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.milkyway.gbusiness.models.CityDataClass.City> getCityList() {
        return null;
    }
    
    public final void setCityList(@org.jetbrains.annotations.Nullable()
    java.util.List<com.milkyway.gbusiness.models.CityDataClass.City> p0) {
    }
    
    public final int getSelectedCountryId() {
        return 0;
    }
    
    public final void setSelectedCountryId(int p0) {
    }
    
    public final int getSelectedStateId() {
        return 0;
    }
    
    public final void setSelectedStateId(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final libs.mjn.fieldset.FieldSetView getTvprofileProfession() {
        return null;
    }
    
    public final void setTvprofileProfession(@org.jetbrains.annotations.NotNull()
    libs.mjn.fieldset.FieldSetView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.milkyway.gbusiness.models.DataXXXXX> getProfessionList() {
        return null;
    }
    
    public final void setProfessionList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.milkyway.gbusiness.models.DataXXXXX> p0) {
    }
    
    @java.lang.Override()
    public void onAttach(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void initializeView(android.view.View view) {
    }
    
    private final void callGetCitiesApi(int stateId) {
    }
    
    private final void callGetStatesApi(int countryId, java.lang.String stateCode) {
    }
    
    private final void callGetCountriesApi(java.lang.String countryCode, java.lang.String stateCode) {
    }
    
    private final boolean checkProfileUpdateValidation() {
        return false;
    }
    
    private final void setClickListener() {
    }
    
    private final java.util.ArrayList<java.lang.String> loadCountriesNameList(java.util.List<com.milkyway.gbusiness.models.CountryDataClass.Country> countryArrayList) {
        return null;
    }
    
    private final java.util.ArrayList<java.lang.String> loadStateNameList(java.util.List<com.milkyway.gbusiness.models.StateDataClass.State> stateArrayList) {
        return null;
    }
    
    private final java.util.ArrayList<java.lang.String> loadCityNameList(java.util.List<com.milkyway.gbusiness.models.CityDataClass.City> cityArrayList) {
        return null;
    }
    
    private final void activateDeactivateAccount() {
    }
    
    private final void updateMobileNumber() {
    }
    
    private final void getChangePassApi() {
    }
    
    private final boolean checkPassValidation() {
        return false;
    }
    
    private final void showDialog() {
    }
    
    private final void userProfileUpdateApi(int selectedCountryId, int selectedStateId, java.lang.String firstName, java.lang.String lastName, java.lang.String city, java.lang.String zipCode, java.lang.String address) {
    }
    
    private final void errorToast(java.lang.String message) {
    }
    
    private final void getProfissionLayout() {
    }
    
    private final android.widget.PopupWindow showAlertFilter() {
        return null;
    }
    
    @java.lang.Override()
    public void onStop() {
    }
    
    private final void dismissPopup() {
    }
    
    private final void getProfileApi() {
    }
    
    private final void setProfileData(com.milkyway.gbusiness.models.ProfileDetailaDataClass getData) {
    }
    
    private final void getProfessionApi() {
    }
    
    public final void OpenCamera() {
    }
    
    public final void OpenGallery() {
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    private final void updateUserImage(java.lang.String encodedString) {
    }
}