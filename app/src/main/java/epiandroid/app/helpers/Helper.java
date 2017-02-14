package epiandroid.app.helpers;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Helper {
    static public Configuration config_file;

    static public void initConfigFile(InputStream s) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        config_file = mapper.readValue(s, Configuration.class);
    }

    public static void setListViewHeightBasedOnChildren(ListView listView, int beg_height) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null)
            return;

        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
        int totalHeight = beg_height;
        View view = null;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            view = listAdapter.getView(i, view, listView);
            if (i == 0)
                view.setLayoutParams(new ViewGroup.LayoutParams(desiredWidth, ViewGroup.LayoutParams.WRAP_CONTENT));

            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

    public static class DownloadImage extends AsyncTask<String, Void, Bitmap> {
        public ImageView imgv;

        public DownloadImage(ImageView imgv) { this.imgv = imgv; }

        @Override
        protected Bitmap doInBackground(String... urls) {
            Bitmap bmpf = null;
            try {
                InputStream in = new URL(urls[0]).openStream();
                bmpf = BitmapFactory.decodeStream(in);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bmpf;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            imgv.setImageBitmap(bitmap);
        }
    }

    public static class Configuration {
        private String endpoint;
        private String[] location;
        private Section section;
        private String[] course;
        private String timeformat;

        public String getTimeformat() {
            return timeformat;
        }

        public void setTimeformat(String timeformat) {
            this.timeformat = timeformat;
        }

        public Configuration() {}

        public String getEndpoint() {
            return endpoint;
        }

        public void setEndpoint(String endpoint) {
            this.endpoint = endpoint;
        }

        public String[] getLocation() {
            return location;
        }

        public void setLocation(String[] location) {
            this.location = location;
        }

        public Section getSection() {
            return section;
        }

        public void setSection(Section home_section) {
            this.section = home_section;
        }

        public String[] getCourse() {
            return course;
        }

        public void setCourse(String[] course) {
            this.course = course;
        }

        public class Section {
            private String modules;
            private String projects;
            private String activities;
            private String internship;
            private String marks;

            public Section() {}

            public String getModules() {
                return modules;
            }

            public void setModules(String modules) {
                this.modules = modules;
            }

            public String getProjects() {
                return projects;
            }

            public void setProjects(String projects) {
                this.projects = projects;
            }

            public String getActivities() {
                return activities;
            }

            public void setActivities(String activities) {
                this.activities = activities;
            }

            public String getInternship() {
                return internship;
            }

            public void setInternship(String internship) {
                this.internship = internship;
            }

            public String getMarks() {
                return marks;
            }

            public void setMarks(String marks) {
                this.marks = marks;
            }
        }
    }
}
